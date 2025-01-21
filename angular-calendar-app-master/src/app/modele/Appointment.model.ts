// appointment.model.ts
export class Appointment {
  uuid?: number;
  date: Date;
  title: string;
  startTime: string;
  endTime: string;
  color?: string;

  constructor(
    title: string,
    date: Date,
    startTime: string,
    endTime: string,
    uuid?: number,
    color?: string
  ) {
    this.title = title;
    this.date = date;
    this.startTime = startTime;
    this.endTime = endTime;
    this.uuid = uuid;
    this.color = color || this.getRandomColor();
  }

  private getRandomColor(): string {
    const r = Math.floor(Math.random() * 256);
    const g = Math.floor(Math.random() * 256);
    const b = Math.floor(Math.random() * 256);
    const a = 0.4;
    return `rgba(${r},${g},${b},${a})`;
  }
}
