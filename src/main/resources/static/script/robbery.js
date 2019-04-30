window.addEventListener("load", function() {
    var robSelector = document.getElementById('robberySelector');
    var robElement = document.querySelectorAll("td > p");
    
    robSelector.addEventListener("change", function() {
        var robOption = this.options[this.selectedIndex].value;
        if(robOption == "job1") {
            robElement[0].textContent = "kubi burayı doldur";
            robElement[1].textContent = "kubi burayı doldur";
            robElement[2].textContent = "kubi burayı doldur";
            robElement[3].textContent = "kubi burayı doldur";
            robElement[4].textContent = "kubi burayı doldur";
        }
        else if(robOption == "job2") {
            robElement[0].textContent = "kubi burayı doldur";
            robElement[1].textContent = "kubi burayı doldur";
            robElement[2].textContent = "kubi burayı doldur";
            robElement[3].textContent = "kubi burayı doldur";
            robElement[4].textContent = "kubi burayı doldur";
        }
        else if(robOption == "job3") {
            robElement[0].textContent = "kubi burayı doldur";
            robElement[1].textContent = "kubi burayı doldur";
            robElement[2].textContent = "kubi burayı doldur";
            robElement[3].textContent = "kubi burayı doldur";
            robElement[4].textContent = "kubi burayı doldur";
        }
    });
});