document.getElementById('Label_0').reset(); // Firefox

new Beanmaker2('Label', {
    servletURL: LM_CONFIG.servletPathStart + 'Labels',
    submitSuccessFunction: ($form) => {
        if (Beanmaker2.getBeanID($form) === '0')
            window.location.reload();
        else
            alert("Changes recorded");
    },
    errorContainerStyles: 'bg-red-100 shadow-md rounded px-8 pt-6 pb-8 mb-4 border border-solid border-red-500 ',
    errorContainerULStyles: 'list-disc marker:text-red-500',
    fieldInErrorStyles: 'border-red-500'
});

new CCTable2('#labels', {
    filteredCssClass: 'hidden',
    zebraCssClass: 'bg-stone-200'
});

const getUpdateParameters = (idLabel, idLanguage, value) => {
    const parameters = {
        method: 'POST',
        cache: 'no-store',
        credentials: 'same-origin'
    };

    const formData = new FormData();
    formData.set('idLabel', idLabel);
    if (idLanguage)
        formData.set('idLanguage', idLanguage);
    formData.set('value', value);

    parameters.body = new URLSearchParams(formData);

    return parameters;
};

document.addEventListener('click', event => {
    const $link = event.target.closest('.edit-label-data');
    if ($link) {
        event.preventDefault();
        const idLabel = $link.dataset.label;
        const idLanguage = $link.dataset.language;
        const value = $link.dataset.value;

        const newValue = prompt("Value:", value);
        if (newValue && newValue !== value) {
            fetch(LM_CONFIG.servletPathStart + 'UpdateLabel', getUpdateParameters(idLabel, idLanguage, newValue))
                .then(response => {
                    if (response.ok && response.headers.get("Content-Type") === "text/json; charset=UTF-8")
                        return response.json();

                    console.log(response.text());

                    throw new Error(`Unexpected response status ${response.status} or content type`);
                })
                .then(data => {
                    if (data.status === 'ok') {
                        $link.innerText = newValue;
                        $link.dataset.value = newValue;
                    } else
                        throw new Error(`Unexpected response status ${data.status}`);
                })
                .catch(error => {
                    console.log(error);
                    alert('An unexpected error has occurred. See console output for more information.');
                });
        }
    }
});

document.addEventListener('click', event => {
    const $link = event.target.closest('.edit-label-name');
    if ($link) {
        event.preventDefault();
        const idLabel = $link.dataset.label;
        const value = $link.dataset.value;

        const newValue = prompt("Value:", value);
        if (newValue && newValue !== value) {
            fetch(LM_CONFIG.servletPathStart + 'UpdateLabelName', getUpdateParameters(idLabel, undefined, newValue))
                .then(response => {
                    if (response.ok && response.headers.get("Content-Type") === "text/json; charset=UTF-8")
                        return response.json();

                    console.log(response.text());

                    throw new Error(`Unexpected response status ${response.status} or content type`);
                })
                .then(data => {
                    switch (data.status) {
                        case 'ok':
                            $link.innerText = newValue;
                            $link.dataset.value = newValue;
                            break;
                        case 'error':
                            alert(data.errorMessage);
                            break;
                        default:
                            throw new Error(`Unexpected response status ${data.status}`);
                    }
                })
                .catch(error => {
                    console.log(error);
                    alert('An unexpected error has occurred. See console output for more information.');
                });
        }
    }
});
