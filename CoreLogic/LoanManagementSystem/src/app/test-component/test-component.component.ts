import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test-component',
  templateUrl: './test-component.component.html',
  styleUrls: ['./test-component.component.css']
})
export class TestComponentComponent implements OnInit {
   test ='Hello , This is Kamrul'
  constructor() { }

  ngOnInit(): void {
  }

}
