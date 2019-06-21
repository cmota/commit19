//
//  SpeakerViewController.swift
//  iosApp
//
//  Created by Carlos Mota on 19/06/2019.
//

import UIKit
import main

class SpeakerViewController: UIViewController {
    
    // MARK: - Navigation
    @IBOutlet weak var speakerImage: UIImageView!
    @IBOutlet weak var speakerName: UILabel!
    @IBOutlet weak var talkTitle: UILabel!
    @IBOutlet weak var talkTime: UILabel!
    @IBOutlet weak var talkDescription: UILabel!
    
    var speaker: Speaker!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    
        self.edgesForExtendedLayout = []
        
        speakerName.text = speaker.speaker
        
        talkTitle.text = speaker.talkTitle
        talkTime.text = speaker.talkSchedule
        talkDescription.text = speaker.talkDescription
        talkDescription.sizeToFit()
        
        guard let url = URL(string: speaker.img) else {
            return
        }
        
        UIImage.loadFrom(url: url) { image in
            self.speakerImage.image = image
        }
        
        speakerImage.layer.cornerRadius = speakerImage.frame.height/2
        
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        super.prepare(for: segue, sender: sender)
    }
}
