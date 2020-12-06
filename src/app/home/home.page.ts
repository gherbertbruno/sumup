import { Component } from '@angular/core';
import { Platform } from '@ionic/angular';
//import { SumUpSDK } from '@ionic-native/sum-up-sdk/ngx';

declare var cordova: any;
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  private imgSrc: String = '';
  constructor(private platform: Platform) { }
  openSumUpLogin() {
    // this.platform.ready().then(() => {
    //   this.sumUpPn.sumupLogin("test").then(resuelt => {

    //   });

    // });
    this.platform.ready().then(() => {

      cordova.plugins.SumUpCordovaPlugin.sumupLogin("test", (r) => {

      }, (e) => {

      });
    });

  }
}
