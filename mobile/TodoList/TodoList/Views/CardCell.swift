//
//  CardCell.swift
//  TodoList
//
//  Created by Chaewan Park on 2020/04/08.
//  Copyright © 2020 Chaewan Park. All rights reserved.
//

import UIKit

class CardCell: UITableViewCell {
    
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var detailLabel: UILabel!
    @IBOutlet weak var authorLabel: UILabel!
    
    var card: Card? = nil {
        didSet {
            guard let card = card else { return }
            titleLabel.text = card.title
            detailLabel.text = card.detail
            authorLabel.text = "Author by \(card.author)"
        }
    }
}
