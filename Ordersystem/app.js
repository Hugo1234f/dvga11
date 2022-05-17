let tableOrders = {
    "1" : {price: [], item: []},
    "2" : {price: [], item: []},
    "3" : {price: [], item: []},
    "4" : {price: [], item: []},
    "5" : {price: [], item: []},
    "6" : {price: [], item: []},
    "7" : {price: [], item: []},
    "8" : {price: [], item: []},
    "9" : {price: [], item: []},
    "10" : {price: [], item: []},
    "11" : {price: [], item: []},
    "12" : {price: [], item: []},
    "13" : {price: [], item: []},
    "14" : {price: [], item: []},
    "15" : {price: [], item: []},
}
let tableCheck = {
    "1" : {price: [], item: []},
    "2" : {price: [], item: []},
    "3" : {price: [], item: []},
    "4" : {price: [], item: []},
    "5" : {price: [], item: []},
    "6" : {price: [], item: []},
    "7" : {price: [], item: []},
    "8" : {price: [], item: []},
    "9" : {price: [], item: []},
    "10" : {price: [], item: []},
    "11" : {price: [], item: []},
    "12" : {price: [], item: []},
    "13" : {price: [], item: []},
    "14" : {price: [], item: []},
    "15" : {price: [], item: []},
}
let currentTable = "1";
let showReciet = true;

$(document).ready(() => {
    readMenu();
    $("aside").addClass("d-none");

    let items = document.getElementsByClassName("itm");
    for(let i = 0; i < items.length; i++) {
        items[i].addEventListener("click", () => {
            itemClicked(items[i]);
        });
    }

    //lisenserad från flaticon.com
    let tableIcon = document.createElement("img");
    $(tableIcon).attr("src", "./side-table.png");
    $(tableIcon).attr("alt", "bild på bord");
    $(tableIcon).css("float", "right");
    $(tableIcon).css("height", "auto");
    $(tableIcon).css("width", "3rem");
    $(tableIcon).css("margin-right", "0.5rem");
    $("nav").append(tableIcon);

    tableIcon.addEventListener("click", ()=> {
        console.log("change table clicked");
    });

    let recietDiv = document.createElement("div");
    $(recietDiv).attr("id", "recietDiv");
    $(recietDiv).css("background-color", "white");
    $(recietDiv).css("width", "90%");
    $(recietDiv).css("margin-top", "2rem");
    $(recietDiv).css("margin-left", "5%");
    $(recietDiv).innerText = "test test";

    let recietContent = "";
    
    let changeBtn = document.createElement("button");
    let commitBtn = document.createElement("button");

    $("footer").append(recietDiv);
    $("footer").click(() => {

        if(showReciet) {
            $(changeBtn).text("Visa order");
            $(commitBtn).text("skicka till kassa");
        }else {
            $(changeBtn).text("Visa kvitto");
            $(commitBtn).text("skicka till kök");
        }

        if(!$("footer").hasClass("activated")) {
            if(showReciet) {
                recietContent = "";
                for(let i = 0; i < tableCheck[currentTable]["item"].length; i++) {
                    recietContent += "<p>" + tableCheck[currentTable]["item"][i] + " (" + tableCheck[currentTable]["price"][i] + ")</p>";
                }
            } else {
                recietContent = "";
                for(let i = 0; i < tableOrders[currentTable]["item"].length; i++) {
                    recietContent += "<p>" + tableOrders[currentTable]["item"][i] + " (" + tableOrders[currentTable]["price"][i] + ")</p>";
                }
            }
            $(recietDiv).empty();
            $(recietDiv).append(recietContent);
        }

        if($("footer").hasClass("activated")) {
            for(let i = 0; i < 500; i++) {
                $("footer").height("-=1");
            }
            $("footer").removeClass("activated"); 
        }else {
            for(let i = 0; i < 500; i++) {
                $("footer").height("+=1");
            } 
            $("footer").addClass("activated");    
        }
        

        
    });


    $(changeBtn).css("background-color", "aqua");
    $(changeBtn).css("margin-left", "5%");
    $(changeBtn).css("width", "9rem");  
    $(changeBtn).css("height", "2rem");
    $(changeBtn).css("float", "left");

    $(commitBtn).css("background-color", "chartreuse");
    $(commitBtn).css("margin-left", "14%");
    $(commitBtn).css("width", "9rem");
    $(commitBtn).css("height", "2rem");

    changeBtn.addEventListener("click", (e) => {
        e.stopPropagation();
        if(showReciet) {
            showReciet = false;
        }else {
            showReciet = true;
        }

        if(showReciet) {
            $(changeBtn).text("Visa order");
            $(commitBtn).text("skicka till kassa");
        }else {
            $(changeBtn).text("Visa kvitto");
            $(commitBtn).text("skicka till kök");
        }

        
            if(showReciet) {
                recietContent = "";
                for(let i = 0; i < tableCheck[currentTable]["item"].length; i++) {
                    recietContent += "<p>" + tableCheck[currentTable]["item"][i] + " (" + tableCheck[currentTable]["price"][i] + ")</p>";
                }
            } else {
                recietContent = "";
                for(let i = 0; i < tableOrders[currentTable]["item"].length; i++) {
                    recietContent += "<p>" + tableOrders[currentTable]["item"][i] + " (" + tableOrders[currentTable]["price"][i] + ")</p>";
                }
            }
            $(recietDiv).empty();
            $(recietDiv).append(recietContent);
        
    });

    commitBtn.addEventListener("click", (e) => {
        e.stopPropagation();
        commitBtn.disabled = true;
        changeBtn.disabled = true;

        let promt = document.createElement("h4");
        $(promt).css("margin-left", "1rem");
        if(showReciet) {
            $(promt).text("Vill du skicka kvittot till kassan?");
        }else {
            $(promt).text("Vill du skicka ordern till köket?");  
        }
        $("footer").append(promt);
    
        let yesBtn = document.createElement("button");
        let noBtn = document.createElement("button");

        $(yesBtn).text("Ja");
        $(noBtn).text("Nej");

        $(yesBtn).css("float", "left");
        $(yesBtn).css("background-color", "chartreuse");
        $(yesBtn).css("margin-left", "5%");
        $(yesBtn).css("width", "9rem");
        $(yesBtn).css("height", "2rem");


        $(noBtn).css("float", "left");
        $(noBtn).css("background-color", "red");
        $(noBtn).css("height", "2rem");
        $(noBtn).css("width", "9rem");
        $(noBtn).css("margin-left", "14%");

        $("footer").append(yesBtn);
        $("footer").append(noBtn);

        yesBtn.addEventListener("click", (e) => {
            e.stopPropagation();
            if(showReciet) {
                console.log(tableCheck[currentTable]);

                tableCheck[currentTable]["item"] = [];
                tableCheck[currentTable]["price"] = [];

                if(showReciet) {
                    recietContent = "";
                    for(let i = 0; i < tableCheck[currentTable]["item"].length; i++) {
                        recietContent += "<p>" + tableCheck[currentTable]["item"][i] + " (" + tableCheck[currentTable]["price"][i] + ")</p>";
                    }
                } else {
                    recietContent = "";
                    for(let i = 0; i < tableOrders[currentTable]["item"].length; i++) {
                        recietContent += "<p>" + tableOrders[currentTable]["item"][i] + " (" + tableOrders[currentTable]["price"][i] + ")</p>";
                    }
                }
                $(recietDiv).empty();
                $(recietDiv).append(recietContent);
            }else {
                for(let i = 0; i < tableOrders[currentTable]["item"].length; i++) {
                    tableCheck[currentTable]["item"].push(tableOrders[currentTable]["item"][i]);
                    tableCheck[currentTable]["price"].push(tableOrders[currentTable]["price"][i]);
                }
                tableOrders[currentTable]["item"] = [];
                tableOrders[currentTable]["price"] = []; 

                if(showReciet) {
                    recietContent = "";
                    for(let i = 0; i < tableCheck[currentTable]["item"].length; i++) {
                        recietContent += "<p>" + tableCheck[currentTable]["item"][i] + " (" + tableCheck[currentTable]["price"][i] + ")</p>";
                    }
                } else {
                    recietContent = "";
                    for(let i = 0; i < tableOrders[currentTable]["item"].length; i++) {
                        recietContent += "<p>" + tableOrders[currentTable]["item"][i] + " (" + tableOrders[currentTable]["price"][i] + ")</p>";
                    }
                }
                $(recietDiv).empty();
                $(recietDiv).append(recietContent);
            }

            commitBtn.disabled = false;
            changeBtn.disabled = false;

            $(promt).remove();
            $(noBtn).remove();
            $(yesBtn).remove();

            
        })

        noBtn.addEventListener("click", (e) => {
            e.stopPropagation();
           
            commitBtn.disabled = false;
            changeBtn.disabled = false;

            $(promt).remove();
            $(noBtn).remove();
            $(yesBtn).remove();
        });

        
    });
    
    

    $("footer").append(changeBtn);
    $("footer").append(commitBtn);

});


function itemClicked(item) {
    $("aside").empty();
    console.log(item.getAttribute("name"));

    let nameRef = document.createElement("h1");
    let picRef = document.createElement("img");
    let itemIngredientsList = document.createElement("ul");

    let itemSource;
    for(headers in menu) {
        let intermidiate = menu[headers];
        for(itm in intermidiate) {
            if(intermidiate[itm]["name"] === item.getAttribute("name")) {
                let itemSource = intermidiate[itm]["contents"];
                for(i in itemSource) {
                    let lstItm = document.createAttribute("li");
                    $(lstItm).text(i);
                    if(itemSource[i].substring(0,2) === "a:") {
                        $(itemIngredientsList).append("<li>" + itemSource[i].replace("a:", "") + "</li>");
                    }else {
                        $(itemIngredientsList).append("<li>" + itemSource[i] + "</li>");
                    }
                    
                }
                
                
                
            }
        }
    }

    nameRef.innerText = item.getAttribute("name");
    picRef.alt = "Bild på vald produkt";
    picRef.style["border"] = "1px solid black";
    $(picRef).css("margin-top", "-2rem");
    $(picRef).css("margin-left", "2rem");
    nameRef.style["padding"] = "3rem";
    $(nameRef).css("margin-top", "-1rem");
    $(nameRef).css("margin-left", "-1rem");
    

    let externalItemLabel = document.createElement("p");
    let externalItemInfo = document.createElement("textarea");
    let sendBtn = document.createElement("button");

    $(sendBtn).addClass("btn");
    $(sendBtn).addClass("btn-primary")

    $(externalItemLabel).css("padding", "1rem 3rem 0.1rem 2rem");
    $(externalItemInfo).css("padding", "2rem 3rem 1rem 2rem");
    $(externalItemInfo).css("margin-left", "2rem");
    $(externalItemInfo).css("border", "2px solid black");
    $(externalItemLabel).text("Övrig information:");

    $(itemIngredientsList).css("margin-top", "-2rem");

    $(sendBtn).css("width", "15rem");
    $(sendBtn).css("margin-left", "2rem");
    $(sendBtn).css("margin-top", "0.5rem");
    $(sendBtn).text("Lägg till i order");

    $("aside").append(picRef);
    $("aside").append(nameRef);
    $("aside").append(itemIngredientsList);
    $("aside").append(externalItemLabel);
    $("aside").append(externalItemInfo);
    $("aside").append(sendBtn);
    

    $("main").addClass("d-none");
    $("footer").addClass("d-none");
    $("aside").removeClass("d-none");

    let returnBtn = document.createElement("button");
    returnBtn.setAttribute("type", "button");
    $(returnBtn).addClass("btn");
    returnBtn.setAttribute("id", "returnBtn");
    returnBtn.innerText = "Tillbaka";
    returnBtn.style["backgroundColor"] = "white";

    $("nav").append(returnBtn);

    returnBtn.addEventListener("click", () => {
        $("aside").addClass("d-none");
        $("main").removeClass("d-none");
        $("footer").removeClass("d-none");
        $(returnBtn).remove();
    });

    sendBtn.addEventListener("click", () => {
        if(externalItemInfo.value === "") {
            console.log("no info");
            tableOrders[currentTable]["item"].push(item.getAttribute("name"));
        }else {
            tableOrders[currentTable]["item"].push(item.getAttribute("name") + ": " + externalItemInfo.value);
        }
        tableOrders[currentTable]["price"].push(item.getAttribute("price"));

        $("aside").addClass("d-none");
        $("main").removeClass("d-none");
        $("footer").removeClass("d-none");
        $(returnBtn).remove();
    })
}

function readMenu() {
    let meny = document.createElement("ul");
    meny.id = "menu";
    $("main").append(meny);

    //---------------------HEADERS------------------------
    for(headers in menu) {
        let headerLink = document.createElement("h1");
        let itemList = document.createElement("ol");
        headerLink.classList.add("hddr");
        itemList.classList.add("itmList");
        headerLink.innerText = headers;

        $("#menu").append(headerLink);
        headerLink.append(itemList);

        //--------------------ITEMS------------------------
        let itemPath = menu[headers];
        for(item in itemPath) {
            let itemLink = document.createElement("h4");
            let ingredientList = document.createElement("ul");
            
            itemLink.classList.add("itm");
            itemLink.setAttribute("name", itemPath[item]["name"]);
            itemLink.setAttribute("price", itemPath[item]["price"]);
            ingredientList.classList.add("ingList");
            itemLink.innerText = itemPath[item]["name"] + ' (' + itemPath[item]["price"] + ":-)";

            itemList.append(itemLink);
            itemLink.append(ingredientList);

            //-------------------INGREDIENTS------------------
            let ingredients = itemPath[item]["contents"];
            let ingredientLink = document.createElement("p");
            ingredientLink.innerHTML = "<p>";

            for(ingredient in ingredients) {
                if(ingredients[ingredient].substring(0,2) === "a:") {
                    ingredientLink.innerText += ingredients[ingredient].substring(2,ingredients[ingredient].length) 
                    + ", ";
                }else {
                    ingredientLink.innerText += ingredients[ingredient] + ", ";
                }
                
            }
            ingredientLink.innerText = ingredientLink.innerText.substring(0,ingredientLink.innerText.length-2);
            ingredientLink.innerHTML += "</p>";
            ingredientLink.classList.add("ingr");

            ingredientList.append(ingredientLink);

        }

        $("main").append("<hr />")
    }
    
   
}