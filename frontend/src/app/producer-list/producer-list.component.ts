import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';
import {ProducerService} from '../Service/producer.service';
import {Producer} from '../models/producer';

@Component({
  selector: 'app-producer-list',
  templateUrl: './producer-list.component.html',
  styleUrls: ['./producer-list.component.css']
})
export class ProducerListComponent implements OnInit {

  producers: Observable<Producer[]>;

  constructor(private producerService: ProducerService,
              private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.producers = this.producerService.getProducerList();
  }

  deleteProducer(id: number) {
    this.producerService.deleteProducer(id)
        .subscribe(
            data => {
              console.log(data);
              this.reloadData();
            },
            error => console.log(error));
  }

  producerDetails(id: number) {
    this.router.navigate(['details1', id]);
  }
}
