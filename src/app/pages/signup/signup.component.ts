import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService: UserService, private snack: MatSnackBar) {}

  public user = {

    userName: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
  };
  ngOnInit(): void { }


  formSubmit() {
   console.log(this.user);
  
    if (this.user.userName == '' || this.user.userName == null) {

      this.snack.open('Username is required!!!','',{
        duration:3000,
        verticalPosition:'top',
        horizontalPosition:'right'
      });
      return;
    }


    //addUser:userService

    this.userService.addUser(this.user).subscribe
    (
      (data:any) => {
        
        console.log(data);
        Swal.fire('Successfully done !!!','user id is : ' +data.id,'success');
        //alert('success');
      },
      (error) => {
        
        console.log(error);
        this.snack.open('something went wrong!!','',{
          duration:3000,
        });

       
      }
    );

  }



}

