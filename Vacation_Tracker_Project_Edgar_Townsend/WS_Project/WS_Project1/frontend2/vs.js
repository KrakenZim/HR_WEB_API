const HOST = "http://localhost:8045"


function createEmployee(){

    const id = document.getElementById('id').value;
    const name = document.getElementById('name').value;
    const start = document.getElementById('start').value;
    const end = document.getElementById('end').value;
    alert("start" + start );
    $.ajax({
        
        method: "post",
        url: `${HOST}/emp/`,
        data: JSON.stringify ({
            "id": id,
            "name" : name,
            "start" : start,
            "end" : end
        }),
        
        headers: {
            'Accept': 'application/json',
            'Content-type' : 'application/json'
        }
    }).done((response) => {
        alert('employee created')
        // print(response)
    }   
    ).fail((obj, textStatus)=>{
        //An error is 400 ror 500
        if (obj && obj.responseJSON && obj.responseJSON.message){
            alert(obj.responseJSON.message)
        }
        if (obj && obj.responseText){
            alert(obj.responseText)
        }
    })
}

function getEmployee(){
    $.ajax(
        {
            method: "get",
            url: `${HOST}/emp/`
        }).done((response) => {
                    var table = document.getElementById("table");
                    table.innerHTML="";
                    var tr="";
                               response.forEach(response=>{
                       tr+='<tr>';
                       tr+='<td>'+response.id+'</td>'+'<td>'+response.name+'</td>'+'<td>'+response.start+'</td>'+'<td>'+ response.end+'</td>';
                       tr+='</tr>'
})

                    table.innerHTML+=tr;
        }).fail((obj, textStatus)=>{
            if (obj && obj.responseJSON && obj.responseJSON.message){
                alert(obj.responseJSON.message)
            }
            if (obj && obj.responseText){
                alert(obj.responseText)
            }
        })
}

function putEmployee(){

    const id = document.getElementById('id').value;
    const name = document.getElementById('name').value;
    const start = document.getElementById('start').value;
    const end = document.getElementById('end').value;
alert("id " + id);
    $.ajax({

        method: "put",
        url: `${HOST}/emp/id/` + id,
        data: JSON.stringify ({
            "id": id,
            "name" : name,
            "start" : start,
            "end" : end
        }),

        headers: {
            'Accept': 'application/json',
            'Content-type' : 'application/json'
        }
    }).done((response) => {
        alert('employee updated')
        // print(response)
    }
    ).fail((obj, textStatus)=>{
        //An error is 400 ror 500
        if (obj && obj.responseJSON && obj.responseJSON.message){
            alert(obj.responseJSON.message)
        }
        if (obj && obj.responseText){
            alert(obj.responseText)
        }
    })
}
function deleteEmployee(){

    const id = document.getElementById('id').value;
    const name = document.getElementById('name').value;
    const start = document.getElementById('start').value;
    const end = document.getElementById('end').value;
alert("id " + id);
    $.ajax({

        method: "delete",
        url: `${HOST}/emp/id/` + id,
        data: JSON.stringify ({
            "id": id,
            "name" : name,
            "start" : start,
            "end" : end
        }),

        headers: {
            'Accept': 'application/json',
            'Content-type' : 'application/json'
        }
    }).done((response) => {
        alert('employee vacation deleted')
        // print(response)
    }
    ).fail((obj, textStatus)=>{
        //An error is 400 ror 500
        if (obj && obj.responseJSON && obj.responseJSON.message){
            alert(obj.responseJSON.message)
        }
        if (obj && obj.responseText){
            alert(obj.responseText)
        }
    })
}