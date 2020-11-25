window.addEventListener("load", function () {
  console.log("Script loaded");
  init();
  getAlldogs();
});

function init() {
  console.log("in init()");

  document.dogForm.lookup.addEventListener("click", function (e) {
    e.preventDefault();
    var dogId = document.dogForm.dogId.value;
    if (!isNaN(dogId) && dogId > 0) {
      getDog(dogId);
    }
  });

  document.newDogForm.submit.addEventListener("click", function (e) {
    e.preventDefault();
    postDog(e);
  });

  document.deleteDogForm.delete.addEventListener("click", function (e) {
    e.preventDefault();
    var deletedDogId = document.deleteDogForm.deletedDogId.value;
    deleteDog(deletedDogId);
  });

  document.updateForm.update.addEventListener("click", function (e) {
    e.preventDefault();
    var updatedDogId = document.dogForm.dogId.value;
    updateDog(updatedDogId);
  });

}

function getAlldogs(){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", 'api/dogs');
	xhr.onreadystatechange = function () {
	  if (xhr.readyState === 4) {
		  var dogs = JSON.parse(xhr.responseText);
		//   displayAllDogs(dogs);
	  }
	};
	xhr.send();
}

function displayAllDogs(dogs) {
  let counter = 0;
  let dogCounter = document.createElement("h4");

  var dataDiv = document.getElementById("dogData");
  dataDiv.textContent = "";

  for (let index = 0; index < dogs.length; index++) {
  		counter++;

    var h2 = document.createElement("h2");
    dataDiv.appendChild(h2);
    h2.textContent = dog.name;

    var img = document.createElement("img");
    img.src = dog.imageUrl;
    img.width = 300;
    img.height = 300;
    dataDiv.appendChild(img);

    var bq = document.createElement("blockquote");
    dataDiv.appendChild(bq);
    bq.textContent = dog.description;

    var ul = document.createElement("ul");
    dataDiv.appendChild(ul);

    var li1 = document.createElement("li");
    dataDiv.appendChild(li1);
    li1.textContent = "Breed: " + dog.breed;

    var li2 = document.createElement("li");
    dataDiv.appendChild(li2);
    li2.textContent = "Size: " + dog.size;

    var li3 = document.createElement("li");
    dataDiv.appendChild(li3);
    li3.textContent = "Aggressive: " + dog.aggressive;
  }
	  dogCounter.textContent = counter + ' dogs available';
	  dataDiv.appendChild(dogCounter);

  let btn = document.createElement("button");
  btn.innerHTML = "Update Dog";
  btn.addEventListener("click", getDogInfoForUpdate(dog));

  document.updateForm.update.addEventListener("click", function (e) {
    e.preventDefault();
    // updateDog(dog.dogId);
  });
}

function getDog(dogId) {
  let xhr = new XMLHttpRequest();
  xhr.open("GET", `api/dogs/${dogId}`);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        let dog = JSON.parse(xhr.responseText);
        displayDog(dog);
      } else {
        let div = document.getElementById("dogData");
        div.textContent = "Dog Not Found";
      }
    }
  };
  xhr.send();
}

function displayDog(dog) {
  var dataDiv = document.getElementById("dogData");
  dataDiv.textContent = "";

  var h2 = document.createElement("h2");
  dataDiv.appendChild(h2);
  h2.textContent = dog.name;

  var img = document.createElement("img");
  img.src = dog.imageUrl;
  img.width = 300;
  img.height = 300;
  dataDiv.appendChild(img);

  var bq = document.createElement("blockquote");
  dataDiv.appendChild(bq);
  bq.textContent = dog.description;

  var ul = document.createElement("ul");
  dataDiv.appendChild(ul);

  var li1 = document.createElement("li");
  dataDiv.appendChild(li1);
  li1.textContent = "Breed: " + dog.breed;

  var li2 = document.createElement("li");
  dataDiv.appendChild(li2);
  li2.textContent = "Size: " + dog.size;

  var li3 = document.createElement("li");
  dataDiv.appendChild(li3);
  li3.textContent = "Aggressive: " + dog.aggressive;

  let btn = document.createElement("button");
  btn.innerHTML = "Update Dog";
  btn.addEventListener("click", getDogInfoForUpdate(dog));

  document.updateForm.update.addEventListener("click", function (e) {
    e.preventDefault();
    // updateDog(dog.dogId);
  });
}

function postDog(e) {
  let xhr = new XMLHttpRequest();
  let form = document.newDogForm;
  let newDog = {
    name: form.name.value,
    breed: form.breed.value,
    size: form.size.value,
    aggressive: form.aggressive.value,
    image: form.image.value,
  };
  xhr.open("POST", "api/dogs");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 201) {
        let dog = JSON.parse(xhr.responseText);
        displayDog(dog);
      } else {
        console.error("Can not create dog, status : " + xhr.status);
      }
    }
  };
  xhr.setRequestHeader("content-type", "application/JSON");
  xhr.send(JSON.stringify(newDog));
}

function updateDog(dogId) {
  let form = document.updateForm;
  let updatedDog = {
    name: form.name.value,
    breed: form.breed.value,
    size: form.size.value,
    aggressive: form.aggressive.value,
    image: form.image.value,
  };
  let xhr = new XMLHttpRequest();
  xhr.open("PUT", `api/dogs/${dogId}`);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status == 200 || xhr.status == 201) {
        updatedDog = JSON.parse(xhr.responseText);
        displayDog(updatedDog);
      } else {
        console.error(xhr.status + ": " + xhr.responseText);
      }
    }
  };
  xhr.setRequestHeader("Content-type", "application/json");
  xhr.send(JSON.stringify(updatedDog));
  updateForm.reset();
}

function deleteDog(dogId) {
  let xhr = new XMLHttpRequest();
  let div = document.getElementById("dogData");
  xhr.open("DELETE", `api/dogs/${dogId}`);

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 204) {
        div.textContent = "Dog Deleted";
      } else {
        div.textContent = "Dog Not Found";
      }
    }
  };
  xhr.send();
}

function getDogInfoForUpdate(dog) {
  var updateForm = document.updateForm;
  updateForm.id.value = dog.id;
  updateForm.description.value = dog.description;
  updateForm.name.value = dog.name;
  updateForm.breed.value = dog.breed;
  updateForm.size.value = dog.size;
  updateForm.image.value = dog.image;
  updateForm.aggressive.value = dog.aggressive;
}
