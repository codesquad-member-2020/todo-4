//
//  Endpoints.swift
//  TodoList
//
//  Created by Chaewan Park on 2020/04/07.
//  Copyright © 2020 Chaewan Park. All rights reserved.
//

import Foundation

class Endpoints {
    static let baseURL = "http://3.34.24.75:8080/api"
    
    static let boardRequestURL = "\(baseURL)/columns"
    static let cardListRequestURL = "\(boardRequestURL)/columnId/cards"
    static let cardRequestURL = "\(cardListRequestURL)/cardId"
}
