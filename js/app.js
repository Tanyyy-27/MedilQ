let medicines = [
  { mbno:'E20302', mname:'Mecobion-OD', mcompany:'Medley Pharma', mqty:100, mexpdate:'8-2025', mpurdate:'6-2-2024', mtype:'Tablet', mpurprice:50, msaleprice:78, mrackno:'M', sid:2, sname:'Rupesh Kamble' },
  { mbno:'l127', mname:'Cystone', mcompany:'Himalaya', mqty:60, mexpdate:'2-2026', mpurdate:'6-2-2024', mtype:'Tablet', mpurprice:60, msaleprice:80, mrackno:'C', sid:7, sname:'Baban Marne' },
  { mbno:'m145', mname:'Metxl-25', mcompany:'Meta Pharma', mqty:10, mexpdate:'5-2025', mpurdate:'6-2-2024', mtype:'Tablet', mpurprice:80, msaleprice:100, mrackno:'M', sid:3, sname:'Ganesh Marne' },
  { mbno:'p20776', mname:'GlimiSave-4', mcompany:'Gilmepiride', mqty:100, mexpdate:'7-2026', mpurdate:'6-2-2024', mtype:'Tablet', mpurprice:70, msaleprice:87, mrackno:'G', sid:1, sname:'Akshay Mahadik' },
  { mbno:'q111', mname:'Vix500', mcompany:'Vix Pharma', mqty:10, mexpdate:'2-2025', mpurdate:'7-2-2024', mtype:'Tablet', mpurprice:25, msaleprice:50, mrackno:'V1', sid:2, sname:'Ganesh Marne' },
  { mbno:'r2025', mname:'Tiger Balm', mcompany:'Makson Pvt Ltd', mqty:50, mexpdate:'2-2027', mpurdate:'6-2-2024', mtype:'Balm', mpurprice:15, msaleprice:27, mrackno:'X', sid:6, sname:'Nitin Pawar' },
  { mbno:'s1234', mname:'Combiflan-5mg', mcompany:'Combifan Pharma', mqty:10, mexpdate:'4-2026', mpurdate:'7-2-2024', mtype:'Tablet', mpurprice:50, msaleprice:100, mrackno:'C1', sid:2, sname:'Rupesh Kamble' },
  { mbno:'s167', mname:'Supradin', mcompany:'Supra Pharma', mqty:50, mexpdate:'8-2025', mpurdate:'6-2-2024', mtype:'Tablet', mpurprice:17, msaleprice:30, mrackno:'S', sid:4, sname:'Mayur Joshi' },
  { mbno:'w12', mname:'Crocine', mcompany:'Crocine Pharma', mqty:10, mexpdate:'2-2026', mpurdate:'7-2-2024', mtype:'Tablet', mpurprice:50, msaleprice:100, mrackno:'C', sid:2, sname:'Rupesh Kamble' },
];

let suppliers = [
  { sid:1, sname:'Akshay Mahadik', saddress:'Kothrud, Pune-411038', sphoneno:'9604856881', semailid:'akshay@gmail.com' },
  { sid:2, sname:'Rupesh Kamble', saddress:'Varaje, Pune-411052', sphoneno:'9869663450', semailid:'rupesh@gmail.com' },
  { sid:3, sname:'Ganesh Marne', saddress:'Sadashiv Peth, Pune-411001', sphoneno:'9922205610', semailid:'ganesh@gmail.com' },
  { sid:4, sname:'Mayur Joshi', saddress:'Sadashiv Peth, Pune-411011', sphoneno:'9898963620', semailid:'mayur@gmail.com' },
  { sid:5, sname:'Dinesh Divekar', saddress:'Kondhwa, Pune', sphoneno:'8989856560', semailid:'dinesh@gmail.com' },
  { sid:6, sname:'Nitin Pawar', saddress:'Pimpri, Pune', sphoneno:'9254646856', semailid:'nitin@gmail.com' },
  { sid:7, sname:'Baban Marne', saddress:'Vadgaon, Pune', sphoneno:'7788556611', semailid:'baban@gmail.com' },
  { sid:9, sname:'Arnav Kulkarni', saddress:'Aundh, Pune', sphoneno:'7852146585', semailid:'arnav@gmail.com' },
  { sid:11, sname:'Sagar Sirke', saddress:'Ganesh Nagar, Pune', sphoneno:'8956237412', semailid:'sagar@gmail.com' },
];

let editingMedBno = null;
let editingSupSid = null;

const sectionTitles = {
  dashboard: ['Dashboard', 'Welcome to MedilQ Inventory Management'],
  'add-medicine': ['Add Medicine', 'Add a new medicine to inventory'],
  'medicine-list': ['Medicine Stock', 'All medicines currently available'],
  'search-medicine': ['Search Medicine', 'Find medicine by name or batch number'],
  'add-supplier': ['Add Supplier', 'Register a new supplier'],
  'supplier-list': ['Supplier List', 'All registered suppliers'],
  'search-supplier': ['Search Supplier', 'Find supplier by name or ID'],
  reports: ['Reports', 'Inventory and supplier summaries'],
  about: ['About', 'About MedilQ'],
};

function setPage(id) {
  document.querySelectorAll('.page').forEach(page => page.classList.remove('active'));
  document.getElementById(id).classList.add('active');
}

function showHome() {
  setPage('home-page');
}

function showLogin() {
  setPage('login-page');
  document.getElementById('login-err').style.display = 'none';
  setTimeout(() => document.getElementById('login-user').focus(), 50);
}

function doLogin() {
  const username = document.getElementById('login-user').value.trim();
  const password = document.getElementById('login-pass').value.trim();
  const err = document.getElementById('login-err');

  if (username === 'tanmay' && password === '1234') {
    err.style.display = 'none';
    setPage('main-page');
    updateDate();
    showSection('dashboard', document.querySelector('.nav-item'));
    return;
  }

  err.textContent = 'Invalid username or password.';
  err.style.display = 'block';
  document.getElementById('login-pass').value = '';
}

function doLogout() {
  document.getElementById('login-user').value = '';
  document.getElementById('login-pass').value = '';
  showHome();
}

function showSection(id, navEl) {
  document.querySelectorAll('.nav-item').forEach(item => item.classList.remove('active'));
  if (navEl) navEl.classList.add('active');

  const [title, sub] = sectionTitles[id] || sectionTitles.dashboard;
  document.getElementById('topbar-title').textContent = title;
  document.getElementById('topbar-sub').textContent = sub;

  const renderers = {
    dashboard: renderDashboard,
    'add-medicine': renderAddMedicine,
    'medicine-list': renderMedicineList,
    'search-medicine': renderSearchMedicine,
    'add-supplier': renderAddSupplier,
    'supplier-list': renderSupplierList,
    'search-supplier': renderSearchSupplier,
    reports: renderReports,
    about: renderAbout,
  };

  renderers[id]();
}

function updateDate() {
  document.getElementById('topbar-date').textContent = new Date().toLocaleDateString('en-IN', {
    weekday: 'short',
    day: 'numeric',
    month: 'short',
    year: 'numeric',
  });
}

function money(value) {
  return `Rs. ${Number(value || 0).toLocaleString('en-IN')}`;
}

function statusBadge(qty) {
  return qty <= 15 ? '<span class="badge badge-red">Low Stock</span>' : '<span class="badge badge-green">In Stock</span>';
}

function renderDashboard() {
  const totalMeds = medicines.length;
  const totalSupp = suppliers.length;
  const lowStock = medicines.filter(m => m.mqty <= 15).length;
  const totalVal = medicines.reduce((sum, med) => sum + med.mqty * med.msaleprice, 0);

  document.getElementById('content-area').innerHTML = `
    <div class="stats-grid">
      ${statCard('Total Medicines', totalMeds, 'Items in inventory', 'var(--green-dark)')}
      ${statCard('Suppliers', totalSupp, 'Active suppliers', 'var(--blue)')}
      ${statCard('Low Stock', lowStock, 'Qty 15 or below', 'var(--red)')}
      ${statCard('Inventory Value', money(totalVal), 'At sale price', 'var(--orange)')}
    </div>

    <div class="quick-grid">
      ${quickAction('Add Medicine', 'New inventory item', 'add-medicine', 1)}
      ${quickAction('Medicine Stock', 'View all medicines', 'medicine-list', 2)}
      ${quickAction('Search Medicine', 'Find by name or batch', 'search-medicine', 3)}
      ${quickAction('Add Supplier', 'Register supplier', 'add-supplier', 4)}
      ${quickAction('Reports', 'View summaries', 'reports', 7)}
    </div>

    <div class="section-panel">
      <div class="panel-header">
        <div>
          <div class="panel-title">Recent Medicines</div>
          <div class="panel-sub">Last 5 medicines in inventory</div>
        </div>
        <span class="badge badge-green">${totalMeds} Total</span>
      </div>
      <div class="table-wrap">
        <table>
          <thead>
            <tr><th>Batch No</th><th>Name</th><th>Company</th><th>Qty</th><th>Type</th><th>Sale Price</th><th>Status</th></tr>
          </thead>
          <tbody>${medicines.slice(-5).reverse().map(medicineRowLite).join('')}</tbody>
        </table>
      </div>
    </div>
  `;
}

function statCard(label, value, sub, color) {
  return `
    <div class="stat-card">
      <div class="stat-label">${label}</div>
      <div class="stat-value" style="color:${color}">${value}</div>
      <div class="stat-sub">${sub}</div>
    </div>
  `;
}

function quickAction(label, sub, section, index) {
  return `
    <button class="quick-btn" type="button" onclick="showSection('${section}', document.querySelectorAll('.nav-item')[${index}])">
      <div class="q-label">${label}</div>
      <div class="q-sub">${sub}</div>
    </button>
  `;
}

function medicineRowLite(m) {
  return `
    <tr>
      <td>${m.mbno}</td>
      <td><b>${m.mname}</b></td>
      <td>${m.mcompany}</td>
      <td>${m.mqty}</td>
      <td><span class="badge badge-blue">${m.mtype}</span></td>
      <td>${money(m.msaleprice)}</td>
      <td>${statusBadge(m.mqty)}</td>
    </tr>
  `;
}

function renderAddMedicine(med = null) {
  editingMedBno = med ? med.mbno : null;
  const isEdit = !!med;
  const today = new Date();
  const todayStr = `${today.getDate()}-${today.getMonth() + 1}-${today.getFullYear()}`;
  const supplierOptions = suppliers.map(s => `<option value="${s.sid}" ${med && med.sid === s.sid ? 'selected' : ''}>${s.sname}</option>`).join('');

  document.getElementById('content-area').innerHTML = `
    <div class="section-panel">
      <div class="panel-header">
        <div>
          <div class="panel-title">${isEdit ? 'Edit Medicine' : 'Add New Medicine'}</div>
          <div class="panel-sub">${isEdit ? 'Update medicine details' : 'Fill in the details to add a new medicine'}</div>
        </div>
      </div>
      <div class="panel-body">
        <div class="form-grid">
          ${field('Batch No *', 'm-mbno', 'text', 'e.g. E20302', med?.mbno || '', isEdit)}
          ${field('Medicine Name *', 'm-mname', 'text', 'e.g. Paracetamol', med?.mname || '')}
          ${field('Company', 'm-mcompany', 'text', 'e.g. Cipla Ltd', med?.mcompany || '')}
          ${field('Quantity', 'm-mqty', 'number', 'e.g. 100', med?.mqty || '')}
          ${field('Expiry Date', 'm-mexpdate', 'text', 'e.g. 12-2026', med?.mexpdate || '')}
          ${field('Purchase Date', 'm-mpurdate', 'text', 'e.g. 1-5-2025', med?.mpurdate || todayStr)}
          <div class="field">
            <label for="m-mtype">Medicine Type</label>
            <select id="m-mtype">${['--Select--','Tablet','Capsule','Syrup','Injection','Cream','Drop','Balm'].map(type => `<option ${med?.mtype === type ? 'selected' : ''}>${type}</option>`).join('')}</select>
          </div>
          ${field('Purchase Price (Rs.)', 'm-mpurprice', 'number', 'e.g. 50', med?.mpurprice || '')}
          ${field('Sale Price (Rs.)', 'm-msaleprice', 'number', 'e.g. 78', med?.msaleprice || '')}
          ${field('Rack No', 'm-mrackno', 'text', 'e.g. A1', med?.mrackno || '')}
          <div class="field">
            <label for="m-supplier">Supplier</label>
            <select id="m-supplier"><option value="">-- Select Supplier --</option>${supplierOptions}</select>
          </div>
        </div>
        <div class="btn-row">
          <button class="btn btn-primary" type="button" onclick="saveMedicine(${isEdit})">${isEdit ? 'Update Medicine' : 'Save Medicine'}</button>
          <button class="btn btn-ghost" type="button" onclick="clearMedForm()">Clear</button>
          <button class="btn btn-ghost" type="button" onclick="showSection('medicine-list', document.querySelectorAll('.nav-item')[2])">Back to Stock</button>
        </div>
      </div>
    </div>
  `;
}

function field(label, id, type, placeholder, value, readonly = false) {
  return `
    <div class="field">
      <label for="${id}">${label}</label>
      <input type="${type}" id="${id}" placeholder="${placeholder}" value="${value}" ${readonly ? 'readonly' : ''}>
    </div>
  `;
}

function saveMedicine(isEdit) {
  const mbno = document.getElementById('m-mbno').value.trim();
  const mname = document.getElementById('m-mname').value.trim();
  if (!mbno || !mname) {
    showToast('Batch No and Medicine Name are required.', true);
    return;
  }

  const supSel = document.getElementById('m-supplier');
  const sid = parseInt(supSel.value, 10) || 0;
  const sname = sid ? supSel.options[supSel.selectedIndex].text : '';
  const newMed = {
    mbno,
    mname,
    mcompany: document.getElementById('m-mcompany').value.trim(),
    mqty: parseInt(document.getElementById('m-mqty').value, 10) || 0,
    mexpdate: document.getElementById('m-mexpdate').value.trim(),
    mpurdate: document.getElementById('m-mpurdate').value.trim(),
    mtype: document.getElementById('m-mtype').value,
    mpurprice: parseFloat(document.getElementById('m-mpurprice').value) || 0,
    msaleprice: parseFloat(document.getElementById('m-msaleprice').value) || 0,
    mrackno: document.getElementById('m-mrackno').value.trim(),
    sid,
    sname,
  };

  if (isEdit) {
    const idx = medicines.findIndex(m => m.mbno === editingMedBno);
    if (idx > -1) medicines[idx] = newMed;
    showToast('Medicine updated successfully.');
  } else {
    if (medicines.some(m => m.mbno === mbno)) {
      showToast('Batch No already exists.', true);
      return;
    }
    medicines.push(newMed);
    clearMedForm();
    showToast('Medicine saved successfully.');
  }
}

function clearMedForm() {
  ['m-mbno','m-mname','m-mcompany','m-mqty','m-mexpdate','m-mpurprice','m-msaleprice','m-mrackno'].forEach(id => {
    const el = document.getElementById(id);
    if (el) el.value = '';
  });
}

function renderMedicineList(filter = '') {
  const query = filter.toLowerCase();
  const list = query ? medicines.filter(m => m.mname.toLowerCase().includes(query) || m.mbno.toLowerCase().includes(query)) : medicines;

  document.getElementById('content-area').innerHTML = `
    <div class="section-panel">
      <div class="panel-header">
        <div>
          <div class="panel-title">Medicine Stock</div>
          <div class="panel-sub">All available medicines</div>
        </div>
        <button class="btn btn-primary" type="button" onclick="showSection('add-medicine', document.querySelectorAll('.nav-item')[1])">Add New</button>
      </div>
      <div class="panel-body" style="padding-bottom:0">
        <div class="search-bar">
          <input type="text" placeholder="Search by medicine name or batch no" oninput="renderMedicineList(this.value)" value="${filter}">
        </div>
      </div>
      ${medicineTable(list, true)}
    </div>
  `;
}

function medicineTable(list, actions = false) {
  return `
    <div class="table-wrap">
      <table>
        <thead>
          <tr>
            <th>Batch No</th><th>Name</th><th>Company</th><th>Qty</th><th>Expiry</th><th>Type</th><th>Purchase</th><th>Sale</th><th>Rack</th><th>Supplier</th>${actions ? '<th>Actions</th>' : ''}
          </tr>
        </thead>
        <tbody>
          ${list.length === 0 ? `<tr><td colspan="${actions ? 11 : 10}"><div class="empty-state">No medicine records found.</div></td></tr>` : list.map(m => `
            <tr>
              <td>${m.mbno}</td>
              <td><b>${m.mname}</b></td>
              <td>${m.mcompany}</td>
              <td>${m.mqty}</td>
              <td>${m.mexpdate}</td>
              <td><span class="badge badge-blue">${m.mtype}</span></td>
              <td>${money(m.mpurprice)}</td>
              <td>${money(m.msaleprice)}</td>
              <td>${m.mrackno}</td>
              <td>${m.sname}</td>
              ${actions ? `<td><div class="tbl-actions"><button class="tbl-btn edit" type="button" onclick="editMedicine('${m.mbno}')">Edit</button><button class="tbl-btn delete" type="button" onclick="deleteMedicine('${m.mbno}')">Delete</button></div></td>` : ''}
            </tr>
          `).join('')}
        </tbody>
      </table>
    </div>
  `;
}

function editMedicine(mbno) {
  const med = medicines.find(m => m.mbno === mbno);
  if (med) {
    document.querySelectorAll('.nav-item')[1].classList.add('active');
    renderAddMedicine(med);
    document.getElementById('topbar-title').textContent = 'Edit Medicine';
  }
}

function deleteMedicine(mbno) {
  openConfirm(() => {
    medicines = medicines.filter(m => m.mbno !== mbno);
    renderMedicineList();
    showToast('Medicine deleted.');
  });
}

function renderSearchMedicine() {
  document.getElementById('content-area').innerHTML = `
    <div class="section-panel">
      <div class="panel-header">
        <div>
          <div class="panel-title">Search Medicine</div>
          <div class="panel-sub">Find medicine by batch number or name</div>
        </div>
      </div>
      <div class="panel-body">
        <div class="form-grid">
          ${field('Batch No', 'sm-batch', 'text', 'Enter batch number', '')}
          ${field('Medicine Name', 'sm-name', 'text', 'Enter medicine name', '')}
        </div>
        <div class="btn-row" style="border:0;padding-top:0;margin-bottom:22px">
          <button class="btn btn-primary" type="button" onclick="doSearchMed()">Search</button>
          <button class="btn btn-ghost" type="button" onclick="renderMedResults(medicines)">View All</button>
          <button class="btn btn-ghost" type="button" onclick="clearSearchMed()">Clear</button>
        </div>
        <div id="search-med-results"></div>
      </div>
    </div>
  `;
}

function doSearchMed() {
  const batch = document.getElementById('sm-batch').value.trim().toLowerCase();
  const name = document.getElementById('sm-name').value.trim().toLowerCase();
  if (!batch && !name) {
    showToast('Please enter a batch number or medicine name.', true);
    return;
  }
  renderMedResults(medicines.filter(m => (batch && m.mbno.toLowerCase().includes(batch)) || (name && m.mname.toLowerCase().includes(name))));
}

function clearSearchMed() {
  document.getElementById('sm-batch').value = '';
  document.getElementById('sm-name').value = '';
  document.getElementById('search-med-results').innerHTML = '';
}

function renderMedResults(list) {
  document.getElementById('search-med-results').innerHTML = `
    <div style="font-size:13px;color:var(--muted);margin-bottom:12px">${list.length} result(s) found</div>
    ${medicineTable(list, false)}
  `;
}

function renderAddSupplier(sup = null) {
  editingSupSid = sup ? sup.sid : null;
  const isEdit = !!sup;
  document.getElementById('content-area').innerHTML = `
    <div class="section-panel">
      <div class="panel-header">
        <div>
          <div class="panel-title">${isEdit ? 'Edit Supplier' : 'Add New Supplier'}</div>
          <div class="panel-sub">${isEdit ? 'Update supplier information' : 'Register a new medicine supplier'}</div>
        </div>
      </div>
      <div class="panel-body">
        <div class="form-grid">
          ${field('Supplier Name *', 'sup-sname', 'text', 'Full name', sup?.sname || '')}
          ${field('Address', 'sup-saddress', 'text', 'City, State', sup?.saddress || '')}
          ${field('Phone No', 'sup-sphoneno', 'text', 'e.g. 9876543210', sup?.sphoneno || '')}
          ${field('Email ID', 'sup-semailid', 'email', 'e.g. name@gmail.com', sup?.semailid || '')}
        </div>
        <div class="btn-row">
          <button class="btn btn-primary" type="button" onclick="saveSupplier(${isEdit})">${isEdit ? 'Update Supplier' : 'Save Supplier'}</button>
          <button class="btn btn-ghost" type="button" onclick="clearSupForm()">Clear</button>
          <button class="btn btn-ghost" type="button" onclick="showSection('supplier-list', document.querySelectorAll('.nav-item')[5])">Back to List</button>
        </div>
      </div>
    </div>
  `;
}

function saveSupplier(isEdit) {
  const sname = document.getElementById('sup-sname').value.trim();
  if (!sname) {
    showToast('Supplier name is required.', true);
    return;
  }

  if (isEdit) {
    const supplier = suppliers.find(s => s.sid === editingSupSid);
    if (supplier) {
      supplier.sname = sname;
      supplier.saddress = document.getElementById('sup-saddress').value.trim();
      supplier.sphoneno = document.getElementById('sup-sphoneno').value.trim();
      supplier.semailid = document.getElementById('sup-semailid').value.trim();
    }
    showToast('Supplier updated successfully.');
  } else {
    suppliers.push({
      sid: Math.max(...suppliers.map(s => s.sid), 0) + 1,
      sname,
      saddress: document.getElementById('sup-saddress').value.trim(),
      sphoneno: document.getElementById('sup-sphoneno').value.trim(),
      semailid: document.getElementById('sup-semailid').value.trim(),
    });
    clearSupForm();
    showToast('Supplier saved successfully.');
  }
}

function clearSupForm() {
  ['sup-sname','sup-saddress','sup-sphoneno','sup-semailid'].forEach(id => {
    const el = document.getElementById(id);
    if (el) el.value = '';
  });
}

function renderSupplierList(filter = '') {
  const query = filter.toLowerCase();
  const list = query ? suppliers.filter(s => s.sname.toLowerCase().includes(query)) : suppliers;
  document.getElementById('content-area').innerHTML = `
    <div class="section-panel">
      <div class="panel-header">
        <div>
          <div class="panel-title">Supplier List</div>
          <div class="panel-sub">All registered suppliers</div>
        </div>
        <button class="btn btn-primary" type="button" onclick="showSection('add-supplier', document.querySelectorAll('.nav-item')[4])">Add New</button>
      </div>
      <div class="panel-body" style="padding-bottom:0">
        <div class="search-bar">
          <input type="text" placeholder="Search suppliers" oninput="renderSupplierList(this.value)" value="${filter}">
        </div>
      </div>
      ${supplierTable(list, true)}
    </div>
  `;
}

function supplierTable(list, actions = false) {
  return `
    <div class="table-wrap">
      <table>
        <thead><tr><th>ID</th><th>Name</th><th>Address</th><th>Phone</th><th>Email</th><th>Medicines</th>${actions ? '<th>Actions</th>' : ''}</tr></thead>
        <tbody>
          ${list.length === 0 ? `<tr><td colspan="${actions ? 7 : 6}"><div class="empty-state">No supplier records found.</div></td></tr>` : list.map(s => {
            const medCount = medicines.filter(m => m.sid === s.sid).length;
            return `
              <tr>
                <td>#${s.sid}</td>
                <td><b>${s.sname}</b></td>
                <td>${s.saddress}</td>
                <td>${s.sphoneno}</td>
                <td>${s.semailid}</td>
                <td><span class="badge badge-green">${medCount} items</span></td>
                ${actions ? `<td><div class="tbl-actions"><button class="tbl-btn edit" type="button" onclick="editSupplier(${s.sid})">Edit</button><button class="tbl-btn delete" type="button" onclick="deleteSupplier(${s.sid})">Delete</button></div></td>` : ''}
              </tr>
            `;
          }).join('')}
        </tbody>
      </table>
    </div>
  `;
}

function editSupplier(sid) {
  const supplier = suppliers.find(s => s.sid === sid);
  if (supplier) {
    document.querySelectorAll('.nav-item')[4].classList.add('active');
    renderAddSupplier(supplier);
    document.getElementById('topbar-title').textContent = 'Edit Supplier';
  }
}

function deleteSupplier(sid) {
  openConfirm(() => {
    suppliers = suppliers.filter(s => s.sid !== sid);
    renderSupplierList();
    showToast('Supplier deleted.');
  });
}

function renderSearchSupplier() {
  document.getElementById('content-area').innerHTML = `
    <div class="section-panel">
      <div class="panel-header">
        <div>
          <div class="panel-title">Search Supplier</div>
          <div class="panel-sub">Find supplier by name or ID</div>
        </div>
      </div>
      <div class="panel-body">
        <div class="form-grid">
          ${field('Supplier ID', 'ss-id', 'number', 'Enter supplier ID', '')}
          ${field('Supplier Name', 'ss-name', 'text', 'Enter supplier name', '')}
        </div>
        <div class="btn-row" style="border:0;padding-top:0;margin-bottom:22px">
          <button class="btn btn-primary" type="button" onclick="doSearchSup()">Search</button>
          <button class="btn btn-ghost" type="button" onclick="renderSupResults(suppliers)">View All</button>
          <button class="btn btn-ghost" type="button" onclick="clearSearchSup()">Clear</button>
        </div>
        <div id="search-sup-results"></div>
      </div>
    </div>
  `;
}

function doSearchSup() {
  const id = parseInt(document.getElementById('ss-id').value, 10) || 0;
  const name = document.getElementById('ss-name').value.trim().toLowerCase();
  if (!id && !name) {
    showToast('Please enter ID or supplier name.', true);
    return;
  }
  renderSupResults(suppliers.filter(s => (id && s.sid === id) || (name && s.sname.toLowerCase().includes(name))));
}

function clearSearchSup() {
  document.getElementById('ss-id').value = '';
  document.getElementById('ss-name').value = '';
  document.getElementById('search-sup-results').innerHTML = '';
}

function renderSupResults(list) {
  document.getElementById('search-sup-results').innerHTML = `
    <div style="font-size:13px;color:var(--muted);margin-bottom:12px">${list.length} result(s) found</div>
    ${supplierTable(list, false)}
  `;
}

function renderReports() {
  const purchaseValue = medicines.reduce((sum, m) => sum + m.mqty * m.mpurprice, 0);
  const saleValue = medicines.reduce((sum, m) => sum + m.mqty * m.msaleprice, 0);
  const byType = {};
  medicines.forEach(m => { byType[m.mtype] = (byType[m.mtype] || 0) + 1; });
  const supplierStats = suppliers.map(s => ({
    ...s,
    count: medicines.filter(m => m.sid === s.sid).length,
    val: medicines.filter(m => m.sid === s.sid).reduce((sum, m) => sum + m.mqty * m.msaleprice, 0),
  })).filter(s => s.count > 0).sort((a, b) => b.count - a.count);

  document.getElementById('content-area').innerHTML = `
    <div class="report-grid">
      <div class="report-card">
        <h4>Inventory Summary</h4>
        <div class="report-row"><span class="label">Total Medicines</span><span class="value">${medicines.length}</span></div>
        <div class="report-row"><span class="label">Total Suppliers</span><span class="value">${suppliers.length}</span></div>
        <div class="report-row"><span class="label">Low Stock Items</span><span class="value" style="color:var(--red)">${medicines.filter(m => m.mqty <= 15).length}</span></div>
        <div class="report-row"><span class="label">Purchase Value</span><span class="value">${money(purchaseValue)}</span></div>
        <div class="report-row"><span class="label">Sale Value</span><span class="value" style="color:var(--green-dark)">${money(saleValue)}</span></div>
        <div class="report-row"><span class="label">Potential Profit</span><span class="value" style="color:var(--orange)">${money(saleValue - purchaseValue)}</span></div>
      </div>
      <div class="report-card">
        <h4>Medicines by Type</h4>
        ${Object.entries(byType).map(([type, count]) => `<div class="report-row"><span class="label">${type}</span><span class="value">${count} item${count > 1 ? 's' : ''}</span></div>`).join('')}
      </div>
    </div>
    <div class="section-panel">
      <div class="panel-header">
        <div>
          <div class="panel-title">Supplier-wise Medicine Report</div>
          <div class="panel-sub">Medicine count and stock value per supplier</div>
        </div>
      </div>
      <div class="table-wrap">
        <table>
          <thead><tr><th>Supplier</th><th>Address</th><th>Phone</th><th>Medicine Count</th><th>Stock Value</th></tr></thead>
          <tbody>${supplierStats.map(s => `<tr><td><b>${s.sname}</b></td><td>${s.saddress}</td><td>${s.sphoneno}</td><td><span class="badge badge-green">${s.count} items</span></td><td>${money(s.val)}</td></tr>`).join('')}</tbody>
        </table>
      </div>
    </div>
  `;
}

function renderAbout() {
  document.getElementById('content-area').innerHTML = `
    <div class="section-panel" style="max-width:760px">
      <div class="panel-header">
        <div>
          <div class="panel-title">About MedilQ</div>
          <div class="panel-sub">Store Management Edition</div>
        </div>
      </div>
      <div class="panel-body">
        <div style="display:flex;align-items:center;gap:16px;margin-bottom:22px">
          <img src="assets/medilq-logo.svg" alt="MedilQ logo" class="brand-logo">
          <div>
            <h2>MedilQ Inventory Management</h2>
            <p style="color:var(--muted);margin-top:4px">Version 2.0 Web</p>
          </div>
        </div>
        <div class="report-row"><span class="label">Developer</span><span class="value">Tanmay Yenpure</span></div>
        <div style="margin-top:20px;padding:16px;background:#f6f9fc;border:1px solid var(--line);border-radius:8px;line-height:1.7;color:var(--muted)">
          MedilQ helps pharmacy administrators manage medicine inventory, supplier information,
          stock levels, pricing, and reports from one clean dashboard. The system keeps the original
          inventory workflow simple while presenting it with a professional interface.
        </div>
      </div>
    </div>
  `;
}

function openConfirm(callback) {
  const modal = document.getElementById('confirm-modal');
  modal.classList.add('open');
  document.getElementById('confirm-yes').onclick = () => {
    modal.classList.remove('open');
    callback();
  };
}

function closeModal() {
  document.getElementById('confirm-modal').classList.remove('open');
}

document.getElementById('confirm-modal').addEventListener('click', event => {
  if (event.target === event.currentTarget) closeModal();
});

function showToast(msg, isError = false) {
  const container = document.getElementById('toast-container');
  const toast = document.createElement('div');
  toast.className = `toast${isError ? ' error' : ''}`;
  toast.textContent = msg;
  container.appendChild(toast);
  setTimeout(() => toast.remove(), 3000);
}

function refreshIntroPreview() {
  const meds = document.getElementById('preview-meds');
  const suppliersCount = document.getElementById('preview-suppliers');
  const low = document.getElementById('preview-low');
  if (meds) meds.textContent = medicines.length;
  if (suppliersCount) suppliersCount.textContent = suppliers.length;
  if (low) low.textContent = medicines.filter(m => m.mqty <= 15).length;
}

refreshIntroPreview();
updateDate();
setInterval(updateDate, 60000);
