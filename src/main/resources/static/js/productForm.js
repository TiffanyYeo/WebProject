
//Create an instance object of ProductsController
const productsControl = new ProductsController();
let storeImage = ""

//When user clicks on 'Save Item', calls API to add items to the database
//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();
    // Select the inputs
    const newItemNameInput = document.querySelector('#newItemNameInput');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newItemImageUrl = document.querySelector('#newItemImageFile');
    const newItemStyle = document.querySelector('#newItemStyle');
    const newItemPrice = document.querySelector('#newItemPrice');

    /*
        Do the Validation code here
    */



    // Get the values of the inputs - variable names to be same as MySQL columns
    const name = newItemNameInput.value;
    const description = newItemDescription.value;
    const imageUrl = "images/" + newItemImageUrl.value.replace("C:\\fakepath\\", "");
    // replace -- change the "C:\\fakepath\\" into "" - no value)
    const style = newItemStyle.value;
    const price = newItemPrice.value;

    // Clear the form
    newItemNameInput.value = '';
    newItemDescription.value = '';
    newItemImageUrl.value = '';
    newItemStyle.value = '';
    newItemPrice.value = '';

    // Add the task to the task manager
    productsControl.addItem(name, description, imageUrl, style, price, storeImage);

});

// select file input
const input = document.querySelector('#newItemImageFile');

// add event listener
input.addEventListener('change', () => {
    storeImage = input.files[0];
    //going to send to backend in ItemController.java multipartfile
    //File Object representing the file(s) selected by the user

    //e.g. user uploaded 3 images
    /*
        for (let i=0; i < input.file.length; i++)
        {
            storeInput[i] = input.file[i];
        }

    */
    //input.files.length -> return the number of files that is uploaded to the web from the user.
});
