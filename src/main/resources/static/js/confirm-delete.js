// confirm-delete.js
// Muestra un diálogo de confirmación antes de enviar formularios o seguir enlaces/acciones de eliminación.
(function () {
    'use strict';

    document.addEventListener('click', function (e) {
        const btn = e.target.closest('[data-confirm-delete], .confirm-delete, button[data-confirm-delete], a[data-confirm-delete]');
        if (!btn) return;
        e.preventDefault();
        const msg = btn.dataset.confirmMessage || '¿Eliminar este registro? Esta acción no se puede deshacer.';
        if (!confirm(msg)) return;
        if (btn.tagName === 'A' && btn.href) {
            window.location.href = btn.href;
            return;
        }
        const form = btn.closest('form');
        if (form) {
            form.submit();
            return;
        }
        if (btn.dataset.href) {
            window.location.href = btn.dataset.href;
        }
    });

    document.addEventListener('submit', function (e) {
        const form = e.target.closest('form[data-confirm], form[data-confirm-delete]');
        if (!form) return;
        const msg = form.dataset.confirm || form.dataset.confirmMessage || '¿Eliminar este registro? Esta acción no se puede deshacer.';
        if (!confirm(msg)) e.preventDefault();
    });
})();
