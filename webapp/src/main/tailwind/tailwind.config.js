module.exports = {
    content: ['../webapp/label-manager/index.jsp', 'output.html'],
    theme: {
        extend: {},
    },
    plugins: [
        require('@tailwindcss/typography'),
        require('@tailwindcss/forms'),
    ],
}
