import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Appointment} from "../modele/Appointment.model";
import {apiURL} from "../config";


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {

  constructor(private http: HttpClient) {}

  getAppointments(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(`${apiURL}/evenements`,httpOptions);
  }

  addAppointment(appointment: Appointment): Observable<Appointment> {
    return this.http.post<Appointment>(`${apiURL}/evenements`, appointment,httpOptions);
  }

  updateAppointment(id: number, appointment: Appointment): Observable<Appointment> {
    return this.http.put<Appointment>(`${apiURL}/evenements/${id}`, appointment,httpOptions);
  }

  deleteAppointment(id: number): Observable<void> {
    return this.http.delete<void>(`${apiURL}/evenements/${id}`,httpOptions);
  }
}
