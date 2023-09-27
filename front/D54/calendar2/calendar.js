let now = new Date();
let curYear = now.getFullYear();
let showYear = curYear;
let curMonth = now.getMonth();
let showMonth = curMonth;
let curLastDay = getLastDayofMonth();
let showLastDay = curLastDay;
let curMonthFirst = new Date(curYear, curMonth, 1);
let showMonthFirst = new Date(showYear, showMonth, 1);
let curMonthFirstDay = curMonthFirst.getDay();
let showMonthFirstDay = showMonthFirst.getDay();
let curDate = now.getDate();

function getLastDayofMonth() {
    let lastDayOfTheMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    let leapYear = false;
    if ((showYear % 4 == 0) && (showYear % 100 != 0) || (showYear % 400 == 0))
        leapYear = true;
    lastDayOfTheMonth[1] = leapYear ? 29 : 28;
    return lastDayOfTheMonth[showMonth];
}
showCal();

function monthBf() {
    showMonth -= 1;
    if (showMonth == -1) {
        showMonth = 11;
        showYear -= 1;
    }
    showMonthFirst = new Date(showYear, showMonth, 1);
    showMonthFirstDay = showMonthFirst.getDay();
    showLastDay = getLastDayofMonth();
    showCal();
}

function monthAf() {
    showMonth += 1;
    if (showMonth == 12) {
        showMonth = 0;
        showYear += 1;
    }
    showMonthFirst = new Date(showYear, showMonth, 1);
    showMonthFirstDay = showMonthFirst.getDay();
    showLastDay = getLastDayofMonth();
    showCal();
}

function showCal() {
    let flag = false;
    if (showMonth == curMonth && showYear == curYear) {
        flag = true;
    }
    const monthNames = ["January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"];
    const dayOfTheWeek = ["Sun", "Mon", "Tue", "Wed", "Thurs", "Fri", "Sat"];
    let numOfWeeks = Math.ceil((showMonthFirstDay + showLastDay) / 7);
    let date = 1 - showMonthFirstDay;
    let table = `<table>`;
    table += `<caption> ${showYear}<br> ${monthNames[showMonth]}</caption>`;
    table += `<tr>`;
    for (let i = 0; i < 7; i++) {
        table += `<th>${dayOfTheWeek[i]}</th>`
    }
    table += `</tr>`;
    for (let i = 0; i < numOfWeeks; i++) {
        table += `<tr>`;
        for (let j = 0; j < 7; j++) {
            if (date <= 0) {
                table += `<td></td>`;
                date++;
            }
            else if (date <= showLastDay) {
                if (flag && date == curDate) {
                    table += `<td id = 'today'>${date++}</td>`;
                } else {
                    table += `<td id = 'date'>${date++}</td>`;
                }
            }
        }
        table += `</tr>`;
    }
    table += `</table>`;
    document.getElementById("demo").innerHTML = table;
}