<strong>Description:</strong><br>
This sample app uses the custom cordova plugin to open the login page from the Android SumUp SDK.

<strong>How to add the plugin :</strong><br>
ionic cordova plugin add SumUpCordovaPlugin --variable API_KEY="YOUR_SUMUP_API_KEY"


<strong>How to call the plugin :</strong><br>

```
import { Component } from '@angular/core';
import { Platform } from '@ionic/angular'; 
declare var cordova: any;

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
   
  constructor(private platform: Platform) { }
  
  openSumUpLogin() {
    this.platform.ready().then(() => { 
      cordova.plugins.SumUpCordovaPlugin.sumupLogin("test", (r) => { 
        //Success
        }, (e) => {
        //Error
        });
    });
  }
}
```
