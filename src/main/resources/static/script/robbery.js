window.addEventListener("load", function() {
    var robSelector = document.getElementById('robberySelector');
    var robElement = document.querySelectorAll("td > p");
    
    robSelector.addEventListener("change", function() {
        var robOption = this.options[this.selectedIndex].value;
        if(robOption == "job1") {
            robElement[0].textContent = "-  10";
            robElement[1].textContent = "+  1";
            robElement[2].textContent = "+ $10";
            robElement[3].textContent = "+  1";
            robElement[4].textContent = "+  1";
            robElement[5].textContent = "+  1";
            robElement[6].textContent = "+  1";
        }
        else if(robOption == "job2") {
            robElement[0].textContent = "-  15";
            robElement[1].textContent = "+  2";
            robElement[2].textContent = "+ $20";
            robElement[3].textContent = "+  1";
            robElement[4].textContent = "+  2";
            robElement[5].textContent = "+  1";
            robElement[6].textContent = "+  1";
        }
        else if(robOption == "job3") {
            robElement[0].textContent = "-  20";
            robElement[1].textContent = "+  3";
            robElement[2].textContent = "+ $30";
            robElement[3].textContent = "+  2";
            robElement[4].textContent = "+  2";
            robElement[5].textContent = "+  2";
            robElement[6].textContent = "+  1";
        }
    });
});