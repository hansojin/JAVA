let now = new Date();
let curYear = now.getFullYear();
let curMonth = now.getMonth();
let lastDay = getLastDayofMonth();
let curMonthFirst = new Date(curYear, curMonth, 1);
let curMonthFirstDay = curMonthFirst.getDay();
let curDate = now.getDate();
let curHour = now.getHours();
let curMinute = now.getMinutes();
let curTime = getCurTime(curHour, curMinute);

// 윤년 계산
function getLastDayofMonth() {
    let lastDayOfTheMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    let leapYear = false;
    if ((curYear % 4 == 0) && (curYear % 100 != 0) || (curYear % 400 == 0))
        leapYear = true;
    lastDayOfTheMonth[1] = leapYear ? 29 : 28;
    return lastDayOfTheMonth[curMonth];
}

// 오전오후 계산
function getCurTime(hour, min) {
    min = min.toString().padStart(2, '0');
    if (hour > 12) {
        hour = hour - 12;
        return hour + ':' + min + 'PM';
    }
    else {
        return hour + ':' + min + 'AM';
    }
}

const dayOfTheWeek = ["일", "월", "화", "수", "목", "금", "토"];
let numOfWeeks = Math.ceil((curMonthFirstDay + lastDay) / 7);
let date = 1 - curMonthFirstDay;
let table = `<table border='1'>`;
table += `<caption>${curYear}년 ${curMonth + 1}월</caption>`;
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
        else if (date <= lastDay) {
            if (date == curDate) {
                table += `<td>${date++}<br>${curTime}</td>`;
            }
            else {
                table += `<td>${date++}</td>`;
            }
        }
    }
    table += `</tr>`;
}
table += `</table>`;
document.getElementById("demo").innerHTML = table;