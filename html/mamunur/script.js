const body = document.body;
const themeToggle = document.getElementById('themeToggle');

const brightBackgrounds = [
    "linear-gradient(135deg, #1A2980, #26D0CE)",
    "linear-gradient(135deg, #000000, #4A00E0, #8E2DE2)",
    "linear-gradient(135deg, #0F2027, #203A43, #2C5364)",
    "linear-gradient(135deg, #3A0CA3, #7209B7, #F72585)",
    "linear-gradient(135deg, #0D324D, #7F5A83, #A8C0FF)",
    "linear-gradient(135deg, #6F0000, #200122)",
    "linear-gradient(135deg, #16222A, #3A6073)",
    "linear-gradient(135deg, #1D4350, #A43931)",
    "linear-gradient(135deg, #3E5151, #DECBA4)"
];

const darkBackgrounds = [
    "linear-gradient(135deg, #0a0a0a, #1a1a2e)",
    "linear-gradient(135deg, #0f0f1e, #2c2c54)",
    "linear-gradient(135deg, #1a1a2e, #16213e)",
    "linear-gradient(135deg, #0d0221, #3d0645)",
    "linear-gradient(135deg, #000000, #1a1a3e)",
    "linear-gradient(135deg, #1b1b3f, #2d2d60)",
    "linear-gradient(135deg, #0a0e27, #1f1f4d)",
    "linear-gradient(135deg, #15152b, #2d2d44)",
    "linear-gradient(135deg, #0d0d1f, #2c2c4a)"
];

let index = 0;

const savedTheme = localStorage.getItem('theme') || 'light';
if (savedTheme === 'dark') body.classList.add('dark-theme');

function applyBackground() {
    const list = body.classList.contains('dark-theme')
        ? darkBackgrounds
        : brightBackgrounds;

    body.style.background = list[index];
    index = (index + 1) % list.length;
}

themeToggle.textContent = body.classList.contains('dark-theme') ? '☀️' : '🌙';

themeToggle.addEventListener('click', () => {
    body.classList.toggle('dark-theme');
    localStorage.setItem('theme',
        body.classList.contains('dark-theme') ? 'dark' : 'light'
    );
    themeToggle.textContent = body.classList.contains('dark-theme') ? '☀️' : '🌙';
    index = 0;
    applyBackground();
});

applyBackground();
setInterval(applyBackground, 10000);