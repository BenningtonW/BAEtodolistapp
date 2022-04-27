window.addEventListener('load', () => {
    const form = document.getElementById("new-task-form")
    const input = document.getElementById("input-task")
    const listEl = document.getElementById("tasks")

    form.addEventListener('submit', (e) => {
        e.preventDefault();

        const task = input.value;
        if (!task) {
            alert("Please fill out the task");
            return;
        }
// 
        const taskEl = document.createElement("div");
        taskEl.classList.add("task");
        
        const taskContentEl = document.createElement("div");
        taskContentEl.classList.add("content");
    

        taskEl.appendChild(taskContentEl);

        const taskInputEl = document.createElement("input");
        taskInputEl.classList.add("text");
        taskInputEl.type = "text";
        taskInputEl.value = task;
        taskInputEl.setAttribute("readonly", "readonly");

        taskContentEl.appendChild(taskInputEl);

        const taskActionsEl = document.createElement("div");
        taskActionsEl.classList.add("actions");

        const taskEditEl = document.createElement("button");
        taskEditEl.classList.add("edit");
        taskEditEl.innerHTML = "Edit";

        const taskDeleteEl = document.createElement("button");
        taskDeleteEl.classList.add("delete");
        taskDeleteEl.innerHTML = "Delete";

        taskActionsEl.appendChild(taskEditEl);
        taskActionsEl.appendChild(taskDeleteEl);

        taskEl.appendChild(taskActionsEl)

        listEl.appendChild(taskEl);

        input.value = "";

        taskEditEl.addEventListener('click', () => {
            if (taskEditEl.innerText.toLowerCase() == "edit") {
                taskInputEl.removeAttribute("readonly");
                taskInputEl.focus();
                taskEditEl.innerText = "Save";

            } else {
                taskInputEl.setAttribute("readonly", "readonly");
                taskEditEl.innerText = "Edit";
            }
        });
        
        taskDeleteEl.addEventListener('click', () => {
            listEl.removeChild(taskEl);
        });
    // 
    });

});

