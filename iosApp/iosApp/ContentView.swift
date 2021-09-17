import SwiftUI
import shared

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

struct ContentView: View {
    @ObservedObject var cafeResponseItemViewModel =  CafeResponseItemViewModel(repository:DataRepository())
    var body: some View {
        NavigationView {
            List(cafeResponseItemViewModel.cafeResponseItemList, id: \.id) { cafe in
                        CafeItemView(cafeResponseItem: cafe)
                    }
                    .navigationBarTitle(Text("CafeList"), displayMode: .large)
                    .onAppear(perform: {
                        self.cafeResponseItemViewModel.fetch()
                    })
                }
    }
}

struct CafeItemView : View {
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
