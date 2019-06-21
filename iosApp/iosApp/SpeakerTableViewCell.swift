//
//  SpeakerTableViewCell.swift
//  iosApp
//
//  Created by Carlos Mota on 18/06/2019.
//

import UIKit

class SpeakerTableViewCell: UITableViewCell {
    
    //MARK: Properties
    @IBOutlet weak var speakerImage: UIImageView!
    @IBOutlet weak var talkName: UILabel!
    @IBOutlet weak var speakerName: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
}

extension UIImage {
    public static func loadFrom(url: URL, completion: @escaping (_ image: UIImage?) -> ()) {
        DispatchQueue.global().async {
            if let data = try? Data(contentsOf: url) {
                DispatchQueue.main.async {
                    completion(UIImage(data: data))
                }
            } else {
                DispatchQueue.main.async {
                    completion(nil)
                }
            }
        }
    }
}
