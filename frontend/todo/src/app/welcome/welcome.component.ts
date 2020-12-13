import { BasicAuthenticationService } from './../service/basic-authentication.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';



@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})


export class WelcomeComponent implements OnInit {

  name="";

  constructor(
    private route:ActivatedRoute, private basicAuthenticationService: BasicAuthenticationService) { 

  }

  ngOnInit(){
    this.name = this.basicAuthenticationService.getAuthenticatedUser();
  }
}
