import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models/user.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  constructor(private http:HttpClient) {}
  
	private userUrl = '/api';

  /*
   * Get the list of user using get method in json format
   */
  public getUsers() {
    console.log(this.userUrl);
    return this.http.get<User[]>(this.userUrl+"/userlist");
  }

  public deleteUser(user) {
    return this.http.delete(this.userUrl + "/delete/"+ user.id);
  }

  public createUser(user) {
    console.log("Create a user");
    return this.http.post<User>(this.userUrl+"/add", user);
  }

}