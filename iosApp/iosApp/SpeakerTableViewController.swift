import UIKit
import main

class SpeakerTableViewController: UITableViewController, ISpeakersListView {
    
    private lazy var presenter = ServiceLocator.init().getSpeakersListPresenter
    
    private var speakers = [Speaker]()
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        presenter.attachView(view: self)

        setStatusBar()
    }
    
    override var preferredStatusBarStyle : UIStatusBarStyle {
        return UIStatusBarStyle.lightContent
    }
    
    private func setStatusBar() {
        navigationItem.title = "commitporto"
        
        guard let statusBarView = UIApplication.shared.value(forKeyPath: "statusBarWindow.statusBar") as? UIView else {
                return
            }
        statusBarView.backgroundColor = UIColor(hexString: "#B83032")
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return speakers.count
    }
        
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cellIdentifier = "SpeakerTableViewCell"

        guard let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier, for: indexPath) as? SpeakerTableViewCell  else {
            fatalError("The dequeued cell is not an instance of SpeakerTableViewCell.")
        }
        
        let speaker = speakers[indexPath.row]
        
        cell.talkName.text = speaker.talkTitle
        cell.speakerName.text = speaker.speaker
        
        guard let url = URL(string: speaker.img) else {
            return cell
        }
        
        UIImage.loadFrom(url: url) { image in
            cell.speakerImage.image = image
        }
        
        cell.speakerImage.layer.cornerRadius = cell.speakerImage.frame.height/2
        
        return cell
    }
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let indexPath = tableView.indexPathForSelectedRow
        let index = indexPath?.row
        
        let speakerViewController = segue.destination as! SpeakerViewController
        speakerViewController.speaker = speakers[index!]
    }
    
    func onSpeakersListFetched(speakers: [Speaker]) {
        self.speakers = speakers
        print("new speakers list=\(speakers)")
        
        self.tableView.reloadData()
    }
    
    func onSpeakersListFailed(e: KotlinException) {
        print("Unable to fetch speakers list")
    }
}

extension UIColor {
    convenience init(hexString: String, alpha: CGFloat = 1.0) {
        var hexInt: UInt32 = 0
        let scanner = Scanner(string: hexString)
        scanner.charactersToBeSkipped = CharacterSet(charactersIn: "#")
        scanner.scanHexInt32(&hexInt)
        
        let red = CGFloat((hexInt & 0xff0000) >> 16) / 255.0
        let green = CGFloat((hexInt & 0xff00) >> 8) / 255.0
        let blue = CGFloat((hexInt & 0xff) >> 0) / 255.0
        let alpha = alpha
        
        self.init(red: red, green: green, blue: blue, alpha: alpha)
    }
}
