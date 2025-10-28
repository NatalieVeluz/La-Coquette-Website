import { Component } from '@angular/core';

@Component({
  selector: 'app-xbox',
  // make sure this line does NOT exist:
  // standalone: true,
  // or explicitly mark it false:
  standalone: false,
  templateUrl: './xbox.component.html',
  styleUrls: ['./xbox.component.css']
})
export class XboxComponent { }
