import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  users:any

  constructor( private http:HttpClient) { }

  ngOnInit(): void {
      //get user

    let response= this.http.get("http://localhost:8082/user/");
    response.subscribe((data)=>this.users.data);
  }
  }


