import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})



export class AppComponent {
  display: any;
  constructor(private http: HttpClient) {
    this.http.get('http://localhost:3000/express').subscribe((data:any) => {
      this.display = data
    })
  }
}
