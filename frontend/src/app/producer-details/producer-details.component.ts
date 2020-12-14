import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProducerService} from '../Service/producer.service';
import {Producer} from '../models/producer';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-producer-details',
  templateUrl: './producer-details.component.html',
  styleUrls: ['./producer-details.component.css']
})
export class ProducerDetailsComponent implements OnInit {

  id: number;
  producer: Producer;

  constructor(private route: ActivatedRoute, private router: Router,
              private producerService: ProducerService) { }

  ngOnInit() {
    this.producer = new Producer();

    this.id = this.route.snapshot.params.id;

    this.producerService.getProducer(this.id)
        .subscribe(data => {
          console.log(data);
          this.producer = data;
        }, error => console.log(error));
  }

  list() {
    this.router.navigate(['producers']);
  }
}
