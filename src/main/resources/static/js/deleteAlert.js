function confirmDeleteProduct() {
    Swal.fire({
        title: 'Confirmar eliminación',
        text: '¿Estás seguro de querer eliminar este registro?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#DC3545',
        confirmButtonText: 'Si, eliminar',
        cancelButtonText: 'Cancelar',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            document.getElementById('deleteForm').submit();
        }
    });
}

function confirmDelete(button) {
    const form = button.closest('.delete-form');
    
    Swal.fire({
        title: 'Confirmar eliminación',
        text: '¿Estás seguro de querer eliminar este registro?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#DC3545',
        confirmButtonText: 'Si, eliminar',
        cancelButtonText: 'Cancelar',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            form.submit();
        }
    });
}