function showPassword () {
    let inputPass = document.getElementById('password')
    let btnShowPass = document.getElementById('btn-password')

    if(inputPass.type === 'password') {
        inputPass.setAttribute('type','text')
        btnShowPass.classList.replace('fa-eye','fa-eye-slash')
    } else {
        inputPass.setAttribute('type','password')
        btnShowPass.classList.replace('fa-eye-slash','fa-eye')
    }
}

function cpfMask() {
    const cpfInput = document.getElementById('cpf')
    let cpfInputLength = cpfInput.value.length
    if (cpfInputLength === 3 || cpfInputLength === 7) {
        cpfInput.value += '.'
    } else if(cpfInputLength === 11) {
        cpfInput.value += '-'
    }
}

function cnpjMask() { 
    const cnpjInput = document.getElementById('cnpj')
    let cnpjInputLength = cnpjInput.value.length
    if (cnpjInputLength === 2 || cnpjInputLength === 6) {
        cnpjInput.value += '.'
    } else if(cnpjInputLength === 10) {
        cnpjInput.value += '/'
    } else if(cnpjInputLength === 15) {
        cnpjInput.value += '-'
    }
}

let slideIndex = [1,1];
let slideId = ["slideSquad"]
showSlides(1, 0);
showSlides(1, 1);

function contadorSlides(n, no) {
  showSlides(slideIndex[no] += n, no);
}

function showSlides(n, no) {
  let i;
  let x = document.getElementsByClassName(slideId[no]);
  if (n > x.length) {slideIndex[no] = 1}    
  if (n < 1) {slideIndex[no] = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex[no]-1].style.display = "block";  
}

const carregarVideos = () => {

    const dataAtt = document.querySelectorAll("[data]");
    
    dataAtt.forEach((elemento) => {
    if (elemento.getBoundingClientRect().top < window.innerHeight) {
        elemento.src = elemento.getAttribute("data");
        elemento.removeAttribute("data")
    }
})
};
    
 
window.onscroll = () => {
    carregarVideos()
    console.log("escrollou!");
    };