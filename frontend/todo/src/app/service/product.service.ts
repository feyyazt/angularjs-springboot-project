import { Injectable } from '@angular/core';
import { Page } from '../common/page';
import {Observable} from "rxjs/Rx";
import {map} from "rxjs/internal/operators";
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private apiService:ApiService) { }

  getAllPageable(page) : Observable<any>{
    return this.apiService.get('/products/pagination',page).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          return {};
        }
      }
    ));
  }


}
