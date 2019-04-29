def Boolean call(Integer nDays,Date date){
    Date today = new Date()
    Calendar now = new GregorianCalendar()
    now.setTime(today)
    if (nDays > 0 ) {
       nDays = nDays * -1
    }
    now.add(Calendar.DAY_OF_MONTH,nDays)

    Calendar then = new GregorianCalendar()
    then.setTime(date)

    return ( then.getTime() < now.getTime() ) 

}
