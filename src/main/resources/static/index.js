
    const form = document.getElementById("new-task-form")
    const input = document.getElementById("input-task")
    const listEl = document.getElementById("tasks")


    form.addEventListener('submit', (e) => {
        e.preventDefault();
// stops from refreshing page
        const task = input.value;
        if (!task) {
            alert("Please fill out the task");
            return;
        }
        axios.post("http://localhost:8080/create", {taskToDo: task}).then(res => console.log(task)).catch(err => console.error(err));
// 
        

       
    // 
    });


const renderTask = (task) => {

    const taskEl = document.createElement("div");
    taskEl.classList.add("task");
    
    const taskContentEl = document.createElement("div");
    taskContentEl.classList.add("content");

    taskContentEl.textContent = task.taskToDo

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
    taskEditEl.id=task.id; 
    

    const taskDeleteEl = document.createElement("button");
    taskDeleteEl.classList.add("delete");
    taskDeleteEl.innerHTML = "Delete";
    taskDeleteEl.setAttribute('onClick', "deleteTask(this.id)");
    taskDeleteEl.id=task.id;

    

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

    
    

}
   
    

    const getAllTasks = () =>{
    axios.get("http://localhost:8080/getAll").then(res => {
        const tasks = res.data;

        listEl.innerHTML = "";

        tasks.forEach(task => renderTask(task, listEl));   
    
    }).catch(err => console.error(err));}

    const updateTask  = () =>{
        axios.put(`http://localhost:8080/update/${parseInt(taskContentEl.task)}`, data).then((res) => console.log(res)).catch((err) => alert(err));

    }

    const deleteTask = id => {
        axios.delete(`http://localhost:8080/delete/${id}`)
        .then(response => {console.log("RESPONSE: ", response); 
        getAllTasks();})
        .catch(err => console.error(err));
    }
    getAllTasks();