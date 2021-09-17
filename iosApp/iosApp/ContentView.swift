import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var cafeResponceItemViewModel =  CafeResponceItemViewModel(repository:DataRepository())
    var body: some View {
        NavigationView {
            List(cafeResponceItemViewModel.cafeResponseItem, id: \.id) { cafe in
                        CafeView(cafeResponseItem: cafe)
                    }
                    .navigationBarTitle(Text("CafeList"), displayMode: .large)
                    .onAppear(perform: {
                        self.cafeResponceItemViewModel.fetch()
                    })
                }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

struct CafeView : View {
    var cafeResponseItem: CafeResponseItem

    var body: some View {
        HStack {
            VStack(alignment: .leading) {
                Text(cafeResponseItem.name).font(.headline)
                Text(cafeResponseItem.id).font(.subheadline)
            }
        }
    }
}
