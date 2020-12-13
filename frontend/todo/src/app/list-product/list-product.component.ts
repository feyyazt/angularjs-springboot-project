import { Component, OnInit } from '@angular/core';
import {Page} from "../common/page";
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {


  page = new Page();
  tempPage:number;
  cols = [];
  rows = [];

  constructor(private productService:ProductService) { }

  ngOnInit() {
    this.cols = [
      {prop: 'name', name: 'Ürün Adı'},
      {prop: 'price', name: 'Fiyat'},
    ];
    this.setPage({offset:0});
  }

  setPage(pageInfo) {
   this.page.page = pageInfo.offset;
   this.tempPage=pageInfo.offset;
    this.productService.getAllPageable(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.page;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
    });
  }

  
  onSort(event) {
    const sort = event.sorts[0];
    this.page.page=this.tempPage;
    this.page.sort=sort.prop+','+sort.dir
    this.productService.getAllPageable(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.page;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
    });
  }
  



}
