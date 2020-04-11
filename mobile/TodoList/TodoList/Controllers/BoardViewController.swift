//
//  BoardViewController.swift
//  TodoList
//
//  Created by Chaewan Park on 2020/04/06.
//  Copyright © 2020 Chaewan Park. All rights reserved.
//

import UIKit

class BoardViewController: UIViewController {

    @IBOutlet weak var boardStackView: UIStackView!
    
    private var listViewControllers = [UIViewController]()
    private var networkManager: NetworkManager?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        configureSession()
        
        setupTodoLists(for: 3)
        
        requestBoard()
    }
    
    private func configureSession() {
        let config = URLSessionConfiguration.ephemeral
        config.protocolClasses = [URLProtocolMock.self]
        networkManager = NetworkManager(session: URLSession(configuration: config))
    }
    
    private func setupTodoLists(for number: Int) {
        listViewControllers = (0..<number).map { [unowned self] id in
            guard let vc = UILoader.load(viewControllerType: CardListViewController.self,
                                         from: storyboard) else { return nil }
            vc.listID = id
            vc.viewModel = CardListViewModel(with: nil)
            vc.dataSource = CardListDataSource()
            vc.delegate = self
            self.boardStackView.addArrangedSubview(vc.view)
            return vc
        }.compactMap { $0 }
    }
}

extension BoardViewController {
    private func requestBoard() {
        let center = NotificationCenter.default
        networkManager?.requestBoard { result in
            switch result {
            case .failure: return
            case let .success(board):
                let userInfo = board.listPackage
                center.post(name: .boardDidUpdate, object: self, userInfo: userInfo)
            }
        }
    }
    
    private func requestNewCard(card: Card) {
        let center = NotificationCenter.default
        networkManager?.requestNewCard(card: card) { result in
            switch result {
            case .failure: return
            case let .success(response): print(response)
            }
        }
    }
}

extension BoardViewController: CardListViewControllerDelegate {
    func addNewCardDidTouch(listID id: Int?) {
        guard let vc = UILoader.load(viewControllerType: FormViewController.self, from: storyboard) else { return }
        vc.listID = id
        vc.delegate = self
        present(vc, animated: true)
    }
}

extension BoardViewController: FormViewControllerDelegate {
    func newCardDidSubmit(listID id: Int?, card: Card) {
        requestNewCard(card: card)
    }
}

extension Notification.Name {
    static let boardDidUpdate = Notification.Name(rawValue: "boardDidUpdate")
}
