//
//  CafeResponceItemViewModel.swift
//  iosApp
//
//  Created by yuli on 2021/9/17.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class CafeResponceItemViewModel: ObservableObject {
    @Published var cafeResponseItem = [CafeResponseItem]()

    private let repository: DataRepository
    
    init(repository: DataRepository) {
        self.repository = repository
    }
    
    func fetch() {
        repository.fetchCafesFromNetwork(cityName:"taipei"){ result , error in
            if let result = result{
                self.cafeResponseItem = result
            }
        }
    }
}
