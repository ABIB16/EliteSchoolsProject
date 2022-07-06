import {
  Component,
  OnInit,
  AfterViewInit,
  OnDestroy,
  ChangeDetectionStrategy,
  NgZone,
} from '@angular/core';
import { SettingsService } from '@core';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styles: [
    `
      .mat-raised-button {
        margin-right: 8px;
        margin-top: 8px;
      }
    `,
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
  providers: [],
})
export class DashboardComponent implements OnInit, AfterViewInit, OnDestroy {


  constructor(
    private ngZone: NgZone,
    private settings: SettingsService
  ) {}

  ngOnInit() {
  }

  ngAfterViewInit() {

  }

  ngOnDestroy() {
  }

  initChart() {
  }
}
