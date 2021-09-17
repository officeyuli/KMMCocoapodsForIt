import SwiftUI
import shared

struct ContentView: View {
    let dataRepository = DataRepository()
    @State var displayText = "Loading..."


    
    func fetchDataFromNetwork(){
        dataRepository.fetchCafesFromNetwork(cityName:"taipei"){ result , error in
            if let result = result{
                self.displayText = result[0].address
            } else if error != nil{
                self.displayText = "error"
            }
            
        }
    }
    var body: some View {
        Text(displayText).onAppear(){
            fetchDataFromNetwork()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
