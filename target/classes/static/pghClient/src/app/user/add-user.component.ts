import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { UserService } from '../service/user.service';

@Component({
  templateUrl: './add-user.component.html'
})
export class AddUserComponent {
  user: User = new User();

  constructor(private router: Router, private userService: UserService) {

  }

  createUser(): void {
    // console.log("Create function call");
    // console.log(this.user);
    this.userService.createUser(this.user)
        .subscribe( data => {
        	// console.log(this.router);
          	alert("User created successfully.");
          this.router.navigate(['/users']);
        });
  };

}