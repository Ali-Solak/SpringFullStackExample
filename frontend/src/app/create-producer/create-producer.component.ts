import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {ProducerService} from '../Service/producer.service';
import {Producer} from '../models/producer';

@Component({
  selector: 'app-create-producer',
  templateUrl: './create-producer.component.html',
  styleUrls: ['./create-producer.component.css']
})
export class CreateProducerComponent implements OnInit {

  producer: Producer = new Producer();
  submitted = false;

  constructor(private producerService: ProducerService,
              private router: Router) { }

  ngOnInit() {
  }

  newProducer(): void {
    this.submitted = false;
    this.producer = new Producer();
  }

  save() {
    this.producerService.createProducer(this.producer)
        .subscribe(data => console.log(data), error => console.log(error));
    this.producer = new Producer();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/producers']);
  }

}
