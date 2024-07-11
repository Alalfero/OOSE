record DecimalTime(int hour, int minute, int second){
  boolean isEarlierThan(DecimalTime that){
    if (this.hour() < that.hour()) {
      return true;
    } else if (this.hour() == that.hour()) {
      if (this.minute() < that.minute()) {
        return true;
      } else if (this.minute() == that.minute()) {
        return this.second() < that.second();
      }
    }
    return false;
  }
  boolean isLaterThan(DecimalTime that){
    return !isEarlierThan(that) && !(this.hour() == that.hour() && this.minute() == that.minute() && this.second() == that.second());

  }
  DecimalTime minutesLater(int min){
    int newMin = this.minute() + min;
    int checkHour = newMin / 100;
    int hour = this.hour() + checkHour;

    return new DecimalTime(hour % 10, newMin%100, this.second());
  }
  DecimalTime secondsLater(int sec){
    int newSec = this.second() + sec;
    int check = newSec/100;
    int min = this.minute() + check;
    int hour = this.hour() + min/100;

    return new DecimalTime(hour%10, min %100, newSec%100);
  }

  Time toTime(){
    int second = this.second();
    int minToSec = this.minute()*100;
    int hourToSec = this.hour()*10000;
    int sum = second+minToSec+hourToSec;

   double TimeSum= (sum*((24*Math.pow(60,2))/100000)); //Formel für Umrechnung Dezimalsekunden in normale Sekunden

    int hours= (int)TimeSum/3600;
    int minutes = (int)TimeSum/60;
    int seconds = (int)TimeSum;

    return new Time(hours %24,minutes%60 ,seconds%60);
  }
}