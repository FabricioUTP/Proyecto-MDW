function togglePassword(idCampo) {
    const campo = document.getElementById(idCampo);
    campo.type = campo.type === 'password' ? 'text' : 'password';
  }