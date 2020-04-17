//
//  DateFormatterExtensions.swift
//  TodoList
//
//  Created by Chaewan Park on 2020/04/17.
//  Copyright © 2020 Chaewan Park. All rights reserved.
//

import Foundation

extension DateFormatter {
    static let activityTimeDecodingFormatter: DateFormatter = {
        let formatter = DateFormatter()
        formatter.dateFormat = "yyyy-MM-dd'T'HH:mm:ss"
        formatter.locale = Locale(identifier: "en_US_POSIX")
        return formatter
    }()
    
    static let activityTimeDisplayingFormatter: RelativeDateTimeFormatter = {
        let formatter = RelativeDateTimeFormatter()
        formatter.locale = Locale(identifier: "ko-KR")
        formatter.dateTimeStyle = .named
        return formatter
    }()
}
