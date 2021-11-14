import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Time to squeeze these long URLs!';

  squeezeUrl = this.formBuilder.group({
    originalURL: ''
  });

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient
  ) {}

  onSubmit(): void {
    this.squeezeUrl.reset();

  }
}
