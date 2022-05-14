
$(document).ready(() => {
    readMenu();
    $("aside").addClass("d-none");

    let items = document.getElementsByClassName("itm");
    for(let i = 0; i < items.length; i++) {
        items[i].addEventListener("click", () => {
            itemClicked(items[i]);
        });
    }
});


function itemClicked(item) {
    $("aside").empty();
    console.log(item.getAttribute("name"));

    let nameRef = document.createElement("h1");
    let picRef = document.createElement("img");
    

    nameRef.innerText = item.getAttribute("name");
    picRef.alt = "Bild på vald produkt";
    picRef.style["border"] = "1px solid black";


    $("aside").append(picRef);
    $("aside").append(nameRef);

    $("main").addClass("d-none");
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
        $(returnBtn).remove();
    });
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
    }
    
   
}