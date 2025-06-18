<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Edit Personal Information</title>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <!-- Tailwind CDN -->--%>
<%--    <script src="https://cdn.tailwindcss.com"></script>--%>
<%--</head>--%>
<%--<body class="bg-white text-gray-800 font-sans">--%>

<%--<div class="max-w-5xl mx-auto py-10 px-4">--%>
<%--    <h1 class="text-2xl font-bold mb-6">Edit personal information</h1>--%>

<%--    <!-- Form -->--%>
<%--    <form id="infoForm" class="space-y-6">--%>
<%--        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">--%>
<%--            <div>--%>
<%--                <label class="block font-medium mb-1">Name <span class="text-red-500">*</span></label>--%>
<%--                <input type="text" value="Nguyen Van A" class="w-full border border-gray-300 px-4 py-2 rounded-md">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label class="block font-medium mb-1">Email <span class="text-red-500">*</span></label>--%>
<%--                <input type="email" value="nguyenvana@gmail.com" class="w-full border border-gray-300 px-4 py-2 rounded-md">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label class="block font-medium mb-1">Experience <span class="text-red-500">*</span></label>--%>
<%--                <input type="number" value="4" class="w-full border border-gray-300 px-4 py-2 rounded-md">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label class="block font-medium mb-1">Gender <span class="text-red-500">*</span></label>--%>
<%--                <input type="text" value="Male" class="w-full border border-gray-300 px-4 py-2 rounded-md">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label class="block font-medium mb-1">Date Of Birth <span class="text-red-500">*</span></label>--%>
<%--                <input type="date" value="1993-02-11" class="w-full border border-gray-300 px-4 py-2 rounded-md">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label class="block font-medium mb-1">Technology <span class="text-red-500">*</span></label>--%>
<%--                <div class="space-x-2 mt-2">--%>
<%--                    <span class="bg-orange-100 text-orange-700 text-sm font-medium px-3 py-1 rounded-full">Front End</span>--%>
<%--                    <span class="bg-orange-100 text-orange-700 text-sm font-medium px-3 py-1 rounded-full">Back End</span>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <label class="block font-medium mb-1">Description <span class="text-red-500">*</span></label>--%>
<%--            <textarea rows="5" class="w-full border border-gray-300 px-4 py-2 rounded-md">Hello, my name is Nguyen Van A. I graduated from University of Transport and Communications with a degree in Data Science. I have 4 years of experience working in Tech Lead, with a strong focus on ReactJS, Java, Spring Framework, SQL,... I am passionate about learning new things, improving myself every day, and contributing effectively to the team. I am currently looking for opportunities where I can apply my skills, grow professionally, and bring value to the organization.</textarea>--%>
<%--        </div>--%>

<%--        <!-- Buttons -->--%>
<%--        <div class="flex gap-4">--%>
<%--            <button type="button" class="px-6 py-2 border border-red-500 text-red-500 rounded hover:bg-red-50" onclick="openModal('changeInfoModal')">Change Information</button>--%>
<%--            <button type="button" class="px-6 py-2 border border-red-500 text-red-500 rounded hover:bg-red-50" onclick="openModal('changePasswordModal')">Change Password</button>--%>
<%--        </div>--%>
<%--    </form>--%>

<%--    <!-- Modal Change Password -->--%>
<%--    <div class="fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center z-50 hidden" id="changePasswordModal">--%>
<%--        <div class="bg-white w-full max-w-lg p-6 rounded-lg shadow-lg relative">--%>
<%--            <button class="absolute top-4 right-4 text-gray-500 hover:text-gray-700" onclick="closeModal('changePasswordModal')">x</button>--%>
<%--            <h2 class="text-xl font-semibold mb-4">Change Password</h2>--%>
<%--            <form class="space-y-4">--%>
<%--                <div>--%>
<%--                    <label class="block font-medium text-sm mb-1">Old Password <span class="text-red-500">*</span></label>--%>
<%--                    <input type="password" class="w-full border border-gray-300 px-3 py-2 rounded-md" />--%>
<%--                </div>--%>
<%--                <div>--%>
<%--                    <label class="block font-medium text-sm mb-1">New Password <span class="text-red-500">*</span></label>--%>
<%--                    <input type="password" class="w-full border border-gray-300 px-3 py-2 rounded-md" />--%>
<%--                </div>--%>
<%--                <div>--%>
<%--                    <label class="block font-medium text-sm mb-1">Confirm New Password <span class="text-red-500">*</span></label>--%>
<%--                    <input type="password" class="w-full border border-gray-300 px-3 py-2 rounded-md" />--%>
<%--                </div>--%>
<%--                <div class="flex justify-end space-x-4 mt-4">--%>
<%--                    <button type="button" class="px-4 py-2 border rounded-md text-gray-700 hover:bg-gray-100" onclick="closeModal('changePasswordModal')">Cancel</button>--%>
<%--                    <button type="submit" class="px-4 py-2 bg-red-600 text-white rounded-md hover:bg-red-700">Save</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <!-- Modal Change Information -->--%>
<%--    <div class="fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center z-50 hidden" id="changeInfoModal">--%>
<%--        <div class="bg-white w-full max-w-2xl p-6 rounded-lg shadow-lg relative">--%>
<%--            <button class="absolute top-4 right-4 text-gray-500 hover:text-gray-700" onclick="closeModal('changeInfoModal')">x</button>--%>
<%--            <h2 class="text-xl font-semibold mb-4">Change Information</h2>--%>
<%--            <form class="space-y-4">--%>
<%--                <div class="grid grid-cols-1 md:grid-cols-2 gap-4">--%>
<%--                    <div>--%>
<%--                        <label class="block font-medium text-sm mb-1">Name <span class="text-red-500">*</span></label>--%>
<%--                        <input type="text" value="Nguyen Van A" class="w-full border border-gray-300 px-3 py-2 rounded-md" />--%>
<%--                    </div>--%>
<%--                    <div>--%>
<%--                        <label class="block font-medium text-sm mb-1">Email <span class="text-red-500">*</span></label>--%>
<%--                        <input type="email" value="nguyenvana@gmail.com" class="w-full border border-gray-300 px-3 py-2 rounded-md" />--%>
<%--                    </div>--%>
<%--                    <div>--%>
<%--                        <label class="block font-medium text-sm mb-1">Experience <span class="text-red-500">*</span></label>--%>
<%--                        <input type="number" value="4" class="w-full border border-gray-300 px-3 py-2 rounded-md" />--%>
<%--                    </div>--%>
<%--                    <div>--%>
<%--                        <label class="block font-medium text-sm mb-1">Gender <span class="text-red-500">*</span></label>--%>
<%--                        <input type="text" value="Male" class="w-full border border-gray-300 px-3 py-2 rounded-md" />--%>
<%--                    </div>--%>
<%--                    <div>--%>
<%--                        <label class="block font-medium text-sm mb-1">Date Of Birth <span class="text-red-500">*</span></label>--%>
<%--                        <input type="date" value="1993-02-11" class="w-full border border-gray-300 px-3 py-2 rounded-md" />--%>
<%--                    </div>--%>
<%--                    <div>--%>
<%--                        <label class="block font-medium text-sm mb-1">Technology <span class="text-red-500">*</span></label>--%>
<%--                        <div class="mt-2 space-x-2">--%>
<%--                            <span class="bg-orange-100 text-orange-700 text-sm px-3 py-1 rounded-full">Front End</span>--%>
<%--                            <span class="bg-orange-100 text-orange-700 text-sm px-3 py-1 rounded-full">Back End</span>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div>--%>
<%--                    <label class="block font-medium text-sm mb-1">Descriptions <span class="text-red-500">*</span></label>--%>
<%--                    <textarea rows="4" class="w-full border border-gray-300 px-3 py-2 rounded-md">Hello, my name is Nguyen Van A. I graduated from University of Transport and Communications with a degree in Data Science. I have 4 years of experience working in Tech Lead, with a strong focus on ReactJS, Java, Spring Framework, SQL,...</textarea>--%>
<%--                </div>--%>
<%--                <div class="flex justify-end space-x-4 mt-4">--%>
<%--                    <button type="button" class="px-4 py-2 border rounded-md text-gray-700 hover:bg-gray-100" onclick="closeModal('changeInfoModal')">Cancel</button>--%>
<%--                    <button type="submit" class="px-4 py-2 bg-red-600 text-white rounded-md hover:bg-red-700">Save</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <!-- Footer -->--%>
<%--    <footer class="mt-20 border-t pt-10 text-sm text-gray-700">--%>
<%--        <p class="font-semibold mb-6">International Education and Human Resources Development Organization - Rikkei Education</p>--%>
<%--        <div class="grid grid-cols-1 md:grid-cols-3 gap-8">--%>
<%--            <!-- Contact -->--%>
<%--            <div>--%>
<%--                <h3 class="font-semibold mb-2">📍 Hanoi headquarters</h3>--%>
<%--                <p>7th Floor, Block A, Song Da Building, Pham Hung Street, My Dinh 1 Ward, Nam Tu Liem District, Hanoi</p>--%>
<%--                <p class="mt-2">📞 0862 069 233</p>--%>
<%--                <p>📧 academy@rikkeisoft.com</p>--%>
<%--            </div>--%>
<%--            <!-- Quick links -->--%>
<%--            <div>--%>
<%--                <h3 class="font-semibold mb-2">Quick Links</h3>--%>
<%--                <ul class="space-y-1">--%>
<%--                    <li>Overview</li>--%>
<%--                    <li>Internship position</li>--%>
<%--                    <li>Internship application</li>--%>
<%--                    <li>My tasks</li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--            <!-- Branches -->--%>
<%--            <div>--%>
<%--                <h3 class="font-semibold mb-2">List of Branches</h3>--%>
<%--                <p class="font-medium">Branch 1:</p>--%>
<%--                <p>7th Floor, Block A, Song Da Building, Pham Hung Street, My Dinh 1 Ward, Hanoi<br>Phone: 0862 069 233</p>--%>
<%--                <p class="font-medium mt-4">Branch 2:</p>--%>
<%--                <p>3rd Floor, TSA Building, No. 77 Le Trung Nghia Street, Ward 12, Tan Binh District, Ho Chi Minh City<br>Phone: 0962 703 893</p>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </footer>--%>
<%--</div>--%>

<%--<script>--%>
<%--    function openModal(id) {--%>
<%--        // Hide all modals--%>
<%--        document.getElementById('changeInfoModal').classList.add('hidden');--%>
<%--        document.getElementById('changePasswordModal').classList.add('hidden');--%>
<%--        // Show the selected modal--%>
<%--        document.getElementById(id).classList.remove('hidden');--%>
<%--    }--%>

<%--    function closeModal(id) {--%>
<%--        document.getElementById(id).classList.add('hidden');--%>
<%--    }--%>

<%--    // Prevent form submission on button click--%>
<%--    document.querySelectorAll('#infoForm button').forEach(button => {--%>
<%--        button.addEventListener('click', function(e) {--%>
<%--            e.preventDefault();--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>

<%--</body>--%>
<%--</html>--%>





<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Internship positions at Rikkei Education</title>--%>
<%--    <script src="https://cdn.tailwindcss.com"></script>--%>
<%--</head>--%>
<%--<body class="bg-gray-100 font-sans">--%>

<%--<!-- Header -->--%>
<%--<div class="text-white p-5 rounded-b-md bg-cover bg-center" style="background-image: url('https://res.cloudinary.com/dmghszorv/image/upload/v1750209750/image_8_hi7dqr.png');">--%>
<%--    <h1 class="text-xl font-bold">Internship positions at Rikkei Education</h1>--%>
<%--    <p class="text-sm mt-1">Competency and knowledge test before the candidate is considered for an interview</p>--%>
<%--</div>--%>

<%--<div class="flex max-w-7xl mx-auto mt-6">--%>

<%--    <!-- Sidebar -->--%>
<%--    <aside class="w-1/4 p-4">--%>
<%--        <!-- Input with search icon -->--%>
<%--        <div class="relative mb-4">--%>
<%--            <input type="text" placeholder="Search intership position" class="w-full px-3 py-2 border rounded-md pr-10">--%>
<%--            <img src="https://cdn-icons-png.flaticon.com/512/622/622669.png"--%>
<%--                 alt="Search Icon"--%>
<%--                 class="absolute right-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-500">--%>
<%--        </div>--%>

<%--        <!-- Filter icon + label -->--%>
<%--        <div class="flex items-center space-x-2 mb-2">--%>
<%--            <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750209896/Filter_alt_qyjsyj.png"--%>
<%--                 alt="Filter Icon"--%>
<%--                 class="w-5 h-5">--%>
<%--            <p class="text-red-600 font-semibold">Advanced filter tool</p>--%>
<%--        </div>--%>

<%--        <!-- Work location -->--%>
<%--        <div class="mt-4">--%>
<%--            <p class="font-semibold text-gray-700">Work location</p>--%>
<%--            <div class="mt-2 space-y-1">--%>
<%--                <label class="flex items-center"><input type="radio" name="location" class="mr-2">Ho Chi Minh City</label>--%>
<%--                <label class="flex items-center"><input type="radio" name="location" class="mr-2">Ho Noi City</label>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <!-- Work type -->--%>
<%--        <div class="mt-4">--%>
<%--            <p class="font-semibold text-gray-700">Work Type</p>--%>
<%--            <div class="mt-2 space-y-1">--%>
<%--                <label class="flex items-center"><input type="radio" name="type" class="mr-2">Full Time</label>--%>
<%--                <label class="flex items-center"><input type="radio" name="type" class="mr-2">Part Time</label>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </aside>--%>

<%--    <!-- Main content -->--%>
<%--    <main class="w-3/4 bg-white p-6 rounded-md shadow-md">--%>
<%--        <p class="mb-4 text-gray-700">Found 11 matching position</p>--%>

<%--        <div class="space-y-4">--%>
<%--            <!-- First job with Detail button -->--%>
<%--            <div class="border border-red-500 p-4 rounded-md flex justify-between items-start">--%>
<%--                <div class="flex space-x-4">--%>
<%--                    <div class="text-red-600 text-3xl"><img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750086857/Frame_5_1_imt1q4.png" alt=""></div>--%>
<%--                    <div>--%>
<%--                        <p class="font-bold text-red-600">Front End Developer</p>--%>
<%--                        <div class="flex space-x-2 mt-1">--%>
<%--                            <span class="bg-gray-200 text-sm px-2 py-1 rounded">ReactJS</span>--%>
<%--                            <span class="bg-gray-200 text-sm px-2 py-1 rounded">Java</span>--%>
<%--                        </div>--%>
<%--                        <p class="text-gray-500 text-sm mt-1">2 month later</p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="flex flex-col space-y-2">--%>
<%--                    <button class="border border-red-500 text-red-500 px-4 py-1 rounded-md">Detail</button>--%>
<%--                    <button class="bg-red-500 text-white px-4 py-1 rounded-md">Apply</button>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <!-- Remaining 10 jobs -->--%>
<%--            <!-- Copy the block below 10 times -->--%>

<%--            <!-- Job item -->--%>
<%--            <!-- Repeat this block 10 times -->--%>
<%--            <div class="border border-gray-300 p-4 rounded-md flex justify-between items-start">--%>
<%--                <div class="flex space-x-4">--%>
<%--                    <div class="text-gray-500 text-3xl"><img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750086810/Frame_5_epvny2.png" alt=""></div>--%>
<%--                    <div>--%>
<%--                        <p class="font-bold text-gray-800">Front End Developer</p>--%>
<%--                        <div class="flex space-x-2 mt-1">--%>
<%--                            <span class="bg-gray-200 text-sm px-2 py-1 rounded">ReactJS</span>--%>
<%--                            <span class="bg-gray-200 text-sm px-2 py-1 rounded">Java</span>--%>
<%--                        </div>--%>
<%--                        <p class="text-gray-500 text-sm mt-1">2 month later</p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <button class="bg-red-500 text-white px-4 py-1 rounded-md h-fit">Apply</button>--%>
<%--            </div>--%>

<%--            <!-- Repeat above div 9 more times -->--%>
<%--            <!-- For brevity, below are 9 identical entries -->--%>
<%--            <div class="border border-gray-300 p-4 rounded-md flex justify-between items-start"><div class="flex space-x-4"><div class="text-gray-500 text-3xl"><img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750086810/Frame_5_epvny2.png" alt=""></div><div><p class="font-bold text-gray-800">Front End Developer</p><div class="flex space-x-2 mt-1"><span class="bg-gray-200 text-sm px-2 py-1 rounded">ReactJS</span><span class="bg-gray-200 text-sm px-2 py-1 rounded">Java</span></div><p class="text-gray-500 text-sm mt-1">2 month later</p></div></div><button class="bg-red-500 text-white px-4 py-1 rounded-md h-fit">Apply</button></div>--%>
<%--            <div class="border border-gray-300 p-4 rounded-md flex justify-between items-start"><div class="flex space-x-4"><div class="text-gray-500 text-3xl"><img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750086810/Frame_5_epvny2.png" alt=""></div><div><p class="font-bold text-gray-800">Front End Developer</p><div class="flex space-x-2 mt-1"><span class="bg-gray-200 text-sm px-2 py-1 rounded">ReactJS</span><span class="bg-gray-200 text-sm px-2 py-1 rounded">Java</span></div><p class="text-gray-500 text-sm mt-1">2 month later</p></div></div><button class="bg-red-500 text-white px-4 py-1 rounded-md h-fit">Apply</button></div>--%>
<%--            <div class="border border-gray-300 p-4 rounded-md flex justify-between items-start"><div class="flex space-x-4"><div class="text-gray-500 text-3xl"><img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750086810/Frame_5_epvny2.png" alt=""></div><div><p class="font-bold text-gray-800">Front End Developer</p><div class="flex space-x-2 mt-1"><span class="bg-gray-200 text-sm px-2 py-1 rounded">ReactJS</span><span class="bg-gray-200 text-sm px-2 py-1 rounded">Java</span></div><p class="text-gray-500 text-sm mt-1">2 month later</p></div></div><button class="bg-red-500 text-white px-4 py-1 rounded-md h-fit">Apply</button></div>--%>
<%--            <div class="border border-gray-300 p-4 rounded-md flex justify-between items-start"><div class="flex space-x-4"><div class="text-gray-500 text-3xl"><img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750086810/Frame_5_epvny2.png" alt=""></div><div><p class="font-bold text-gray-800">Front End Developer</p><div class="flex space-x-2 mt-1"><span class="bg-gray-200 text-sm px-2 py-1 rounded">ReactJS</span><span class="bg-gray-200 text-sm px-2 py-1 rounded">Java</span></div><p class="text-gray-500 text-sm mt-1">2 month later</p></div></div><button class="bg-red-500 text-white px-4 py-1 rounded-md h-fit">Apply</button></div>--%>
<%--            <div class="border border-gray-300 p-4 rounded-md flex justify-between items-start"><div class="flex space-x-4"><div class="text-gray-500 text-3xl"><img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750086810/Frame_5_epvny2.png" alt=""></div><div><p class="font-bold text-gray-800">Front End Developer</p><div class="flex space-x-2 mt-1"><span class="bg-gray-200 text-sm px-2 py-1 rounded">ReactJS</span><span class="bg-gray-200 text-sm px-2 py-1 rounded">Java</span></div><p class="text-gray-500 text-sm mt-1">2 month later</p></div></div><button class="bg-red-500 text-white px-4 py-1 rounded-md h-fit">Apply</button></div>--%>
<%--            <div class="border border-gray-300 p-4 rounded-md flex justify-between items-start"><div class="flex space-x-4"><div class="text-gray-500 text-3xl"><img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750086810/Frame_5_epvny2.png" alt=""></div><div><p class="font-bold text-gray-800">Front End Developer</p><div class="flex space-x-2 mt-1"><span class="bg-gray-200 text-sm px-2 py-1 rounded">ReactJS</span><span class="bg-gray-200 text-sm px-2 py-1 rounded">Java</span></div><p class="text-gray-500 text-sm mt-1">2 month later</p></div></div><button class="bg-red-500 text-white px-4 py-1 rounded-md h-fit">Apply</button></div>--%>
<%--            <div class="border border-gray-300 p-4 rounded-md flex justify-between items-start"><div class="flex space-x-4"><div class="text-gray-500 text-3xl"><img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750086810/Frame_5_epvny2.png" alt=""></div><div><p class="font-bold text-gray-800">Front End Developer</p><div class="flex space-x-2 mt-1"><span class="bg-gray-200 text-sm px-2 py-1 rounded">ReactJS</span><span class="bg-gray-200 text-sm px-2 py-1 rounded">Java</span></div><p class="text-gray-500 text-sm mt-1">2 month later</p></div></div><button class="bg-red-500 text-white px-4 py-1 rounded-md h-fit">Apply</button></div>--%>

<%--        </div>--%>
<%--    </main>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>







<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Internship positions at Rikkei Education</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
</head>
<body class="bg-gray-100 font-sans ">
<div class="flex max-w-7xl mx-auto mt-6">
    <div class="flex gap-6 p-6">
        <!-- Main content -->
        <div class="w-2/3 space-y-6">
            <!-- Job Overview -->
            <div class="bg-white shadow rounded-md p-6">
                <h2 class="text-lg font-bold mb-3">Front End Developer</h2>
                <div class="flex flex-wrap gap-2 mb-3">
                    <span class="px-2 py-1 bg-blue-100 text-blue-600 text-sm rounded">ReactJS</span>
                    <span class="px-2 py-1 bg-blue-100 text-blue-600 text-sm rounded">Java</span>
                </div>

                <div class="grid grid-cols-3 gap-4 text-sm text-gray-600">
                    <div class="flex items-center gap-2">
                        <i class="fas fa-map-marker-alt text-red-500"></i> <span>Hà Nội</span>
                    </div>
                    <div class="flex items-center gap-2">
                        <i class="fas fa-clock text-yellow-500"></i> <span>Part Time</span>
                    </div>
                    <div class="flex items-center gap-2">
                        <i class="fas fa-user-graduate text-blue-500"></i> <span>Fresher</span>
                    </div>
                </div>

                <div class="mt-3 text-sm text-gray-600 flex items-center gap-2">
                    <i class="fas fa-dollar-sign text-green-500"></i>
                    <span>Range: 1,200$ - 2,200$</span>
                </div>

                <div class="mt-1 text-sm text-gray-500 flex items-center gap-2">
                    <i class="fas fa-calendar-alt text-purple-500"></i>
                    <span>2 month later</span>
                </div>

                <button id="applyNowBtn" class="mt-4 w-full bg-red-600 hover:bg-red-700 text-white font-semibold py-2 rounded">Apply Now</button>
            </div>

            <!-- Job Description -->
            <div class="bg-white shadow rounded-md p-6">
                <h3 class="text-base font-bold border-l-4 border-red-500 pl-2 mb-4">Recruitment Details</h3>

                <h4 class="font-semibold mb-2">I. Mo ta cong viec</h4>
                <ul class="list-decimal list-inside text-sm text-gray-700 space-y-1">
                    <li>Tham gia vào quy trình xây dựng Dashboard, phân tích dữ liệu phục vụ nhu cầu vận hành.</li>
                    <li>Phân tích đưa ra đề xuất phục vụ các quyết định kinh doanh...</li>
                    <li>Tham gia xây dựng nền tảng phân tích dữ liệu BI-Self Service...</li>
                    <li>Tham gia quá trình thiết kế và tổ chức dữ liệu...</li>
                    <li>Triển khai, vận hành, hỗ trợ các dịch vụ khai thác dữ liệu...</li>
                </ul>

                <h4 class="font-semibold mt-4 mb-2">II. Yeu cau ung vien</h4>
                <ul class="list-decimal list-inside text-sm text-gray-700 space-y-1">
                    <li>Sinh viên năm cuối hoặc tốt nghiệp...</li>
                    <li>Có kinh nghiệm trực quan hóa dữ liệu...</li>
                    <li>Có kinh nghiệm làm việc với SQL...</li>
                    <li>Am hiểu về các concept trong Data Warehouse...</li>
                    <li>Có "business sense" tốt...</li>
                    <li>Có khả năng xử lý lượng thông tin lớn...</li>
                    <li>Kỹ năng làm việc nhóm hiệu quả.</li>
                    <li>Kỹ năng giao tiếp tốt, cởi mở, thân thiện.</li>
                </ul>

                <button id="applyNowBtnDesc" class="mt-6 w-full bg-red-600 hover:bg-red-700 text-white font-semibold py-2 rounded">Apply Now</button>
            </div>
        </div>

        <!-- Sidebar with other jobs -->
        <div class="w-1/3 space-y-4">
            <!-- Thẻ job bên phải -->
            <div class="bg-white p-4 shadow rounded-md">
                <h4 class="font-bold mb-2">Front End Developer</h4>
                <div class="flex flex-wrap gap-2 mb-2">
                    <span class="text-xs bg-blue-100 text-blue-600 px-2 py-1 rounded">ReactJS</span>
                    <span class="text-xs bg-blue-100 text-blue-600 px-2 py-1 rounded">Java</span>
                </div>
                <p class="text-sm text-gray-600">Scale: Not updated</p>
                <p class="text-sm text-gray-600">Field: Information technology</p>
                <p class="text-sm text-gray-600">Location: Ha Noi City</p>
            </div>
            <!-- Danh sách các job khác -->
            <div class="space-y-3">
                <div class="border border-gray-300 p-4 rounded-md flex justify-between items-start">
                    <div class="flex space-x-4">
                        <div class="text-gray-500 text-3xl"><img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750086810/Frame_5_epvny2.png" alt=""></div>
                        <div>
                            <p class="font-bold text-gray-800">Front End Developer</p>
                            <div class="flex space-x-2 mt-1">
                                <span class="bg-gray-200 text-sm px-2 py-1 rounded">ReactJS</span>
                                <span class="bg-gray-200 text-sm px-2 py-1 rounded">Java</span>
                            </div>
                            <p class="text-gray-500 text-sm mt-1">2 month later</p>
                        </div>
                    </div>
                    <button class="bg-red-500 text-white px-4 py-1 rounded-md h-fit">Apply</button>
                </div>
                <div class="border border-gray-300 p-4 rounded-md flex justify-between items-start">
                    <div class="flex space-x-4">
                        <div class="text-gray-500 text-3xl"><img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750086810/Frame_5_epvny2.png" alt=""></div>
                        <div>
                            <p class="font-bold text-gray-800">Front End Developer</p>
                            <div class="flex space-x-2 mt-1">
                                <span class="bg-gray-200 text-sm px-2 py-1 rounded">ReactJS</span>
                                <span class="bg-gray-200 text-sm px-2 py-1 rounded">Java</span>
                            </div>
                            <p class="text-gray-500 text-sm mt-1">2 month later</p>
                        </div>
                    </div>
                    <button class="bg-red-500 text-white px-4 py-1 rounded-md h-fit">Apply</button>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Apply Now Modal -->
<div id="applyModal" class="fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center hidden z-50">
    <div class="bg-white p-6 rounded-lg shadow-lg w-96">
        <div class="flex justify-between items-center mb-4">
            <h2 class="text-lg font-semibold">Apply Now</h2>
            <button id="closeModalBtn" class="text-gray-500 hover:text-gray-700">&times;</button>
        </div>
        <form class="space-y-4">
            <div>
                <label class="block text-sm font-medium text-gray-700">CV URL <span class="text-red-500">*</span></label>
                <input type="text" id="cvUrl" class="w-full border border-gray-300 rounded-md px-3 py-2 mt-1" placeholder="Enter CV URL" />
            </div>
            <div class="flex justify-end space-x-2">
                <button type="button" id="cancelModalBtn" class="px-4 py-2 border border-gray-300 rounded-md text-gray-700 hover:bg-gray-100">Cancel</button>
                <button type="submit" id="saveModalBtn" class="px-4 py-2 bg-red-600 text-white rounded-md hover:bg-red-700">Save</button>
            </div>
        </form>
    </div>
</div>

<script>
    // Get all Apply Now buttons
    const applyButtons = document.querySelectorAll('#applyNowBtn, #applyNowBtnDesc, .bg-red-500');
    const modal = document.getElementById('applyModal');
    const closeModalBtn = document.getElementById('closeModalBtn');
    const cancelModalBtn = document.getElementById('cancelModalBtn');

    // Open modal when Apply Now is clicked
    applyButtons.forEach(button => {
        button.addEventListener('click', (e) => {
            e.preventDefault(); // Prevent form submission or default behavior
            modal.classList.remove('hidden');
        });
    });

    // Close modal
    closeModalBtn.addEventListener('click', () => {
        modal.classList.add('hidden');
    });

    cancelModalBtn.addEventListener('click', () => {
        modal.classList.add('hidden');
    });

    // Handle form submission (optional - add your logic here)
    document.querySelector('#applyModal form').addEventListener('submit', (e) => {
        e.preventDefault();
        const cvUrl = document.getElementById('cvUrl').value;
        console.log('CV URL submitted:', cvUrl);
        modal.classList.add('hidden'); // Close modal after submission
    });
</script>
</body>
</html>


<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8" />--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0" />--%>
<%--    <title>My Application</title>--%>
<%--    <script src="https://cdn.tailwindcss.com"></script>--%>
<%--</head>--%>
<%--<body class="bg-gray-100 font-sans">--%>
<%--<div class="max-w-7xl mx-auto mt-6">--%>
<%--    <!-- Header -->--%>
<%--    <div class="bg-white shadow-md p-4 flex justify-between items-center rounded-t-md">--%>
<%--        <h1 class="text-xl font-bold text-red-600">My Application</h1>--%>
<%--&lt;%&ndash;        <span class="text-gray-500 text-sm">Created At</span>&ndash;%&gt;--%>
<%--    </div>--%>

<%--    <!-- Table -->--%>
<%--    <div class="bg-white shadow-md rounded-b-md overflow-hidden">--%>
<%--        <table class="w-full text-sm text-gray-700">--%>
<%--            <thead class="bg-gray-50">--%>
<%--            <tr>--%>
<%--                <th class="py-3 px-4 text-left">STT</th>--%>
<%--                <th class="py-3 px-4 text-left">Recruitment Name</th>--%>
<%--                <th class="py-3 px-4 text-left">Technology</th>--%>
<%--                <th class="py-3 px-4 text-left">Created At</th>--%>
<%--                <th class="py-3 px-4 text-left">Update At</th>--%>
<%--                <th class="py-3 px-4 text-left">Process</th>--%>
<%--                <th class="py-3 px-4 text-left">Actions</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <tr class="border-b">--%>
<%--                <td class="py-3 px-4">1</td>--%>
<%--                <td class="py-3 px-4">Front End Developer</td>--%>
<%--                <td class="px-4 py-2 space-x-1">--%>
<%--                        <span class="bg-orange-100 text-orange-700 px-2 py-1 rounded text-xs">Front End</span>--%>
<%--                    <span class="bg-orange-100 text-yellow-800 text-xs font-medium px-2 py-1 rounded mt-1">Back End</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">10/10/2022</td>--%>
<%--                <td class="py-3 px-4">10/11/2022</td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <span class="bg-orange-100 text-yellow-800 text-xs font-medium px-2 py-1 rounded">PENDING</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <button>--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216145/Button_c2kv6s.png" alt="">--%>
<%--                    </button>--%>
<%--                    <button class="open-modal text-red-500 hover:text-red-700">--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216158/_Button_base_z4xsuv.png" alt="Open Modal" />--%>
<%--                    </button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr class="border-b">--%>
<%--                <td class="py-3 px-4">2</td>--%>
<%--                <td class="py-3 px-4">Back End Developer</td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                        <span class="bg-orange-100 text-orange-700 px-2 py-1 rounded text-xs">Front End</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">10/10/2022</td>--%>
<%--                <td class="py-3 px-4">10/11/2022</td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <span class="bg-orange-100 text-yellow-800 text-xs font-medium px-2 py-1 rounded">PENDING</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <button>--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216145/Button_c2kv6s.png" alt="">--%>
<%--                    </button>--%>
<%--                    <button class="open-modal text-red-500 hover:text-red-700">--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216158/_Button_base_z4xsuv.png" alt="Open Modal" />--%>
<%--                    </button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr class="border-b">--%>
<%--                <td class="py-3 px-4">3</td>--%>
<%--                <td class="py-3 px-4">Full Stack Developer</td>--%>
<%--                <td class="px-4 py-2 space-x-1">--%>
<%--                        <span class="bg-orange-100 text-orange-700 px-2 py-1 rounded text-xs">Front End</span>--%>
<%--                    <span class="bg-orange-100 text-yellow-800 text-xs font-medium px-2 py-1 rounded mt-1">Back End</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">10/10/2022</td>--%>
<%--                <td class="py-3 px-4">10/11/2022</td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <span class="bg-orange-100 text-yellow-800 text-xs font-medium px-2 py-1 rounded">PENDING</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <button>--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216145/Button_c2kv6s.png" alt="">--%>
<%--                    </button>--%>
<%--                    <button class="open-modal text-red-500 hover:text-red-700">--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216158/_Button_base_z4xsuv.png" alt="Open Modal" />--%>
<%--                    </button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr class="border-b">--%>
<%--                <td class="py-3 px-4">4</td>--%>
<%--                <td class="py-3 px-4">Solution Architect RikkeiSoft</td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                        <span class="bg-orange-100 text-orange-700 px-2 py-1 rounded text-xs">Front End</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">10/10/2022</td>--%>
<%--                <td class="py-3 px-4">10/11/2022</td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <span class="bg-purple-100 text-purple-800 text-xs font-medium px-2 py-1 rounded">HANDLING</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <button>--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216145/Button_c2kv6s.png" alt="">--%>
<%--                    </button>--%>
<%--                    <button class="open-modal text-red-500 hover:text-red-700">--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216158/_Button_base_z4xsuv.png" alt="Open Modal" />--%>
<%--                    </button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr class="border-b">--%>
<%--                <td class="py-3 px-4">5</td>--%>
<%--                <td class="py-3 px-4">Project Manager LG</td>--%>
<%--                <td class="px-4 py-2 space-x-1">--%>
<%--                        <span class="bg-orange-100 text-orange-700 px-2 py-1 rounded text-xs">Front End</span>--%>
<%--                    <span class="bg-orange-100 text-yellow-800 text-xs font-medium px-2 py-1 rounded mt-1">Back End</span>--%>
<%--                </td>--%>

<%--                <td class="py-3 px-4">10/10/2022</td>--%>
<%--                <td class="py-3 px-4">10/11/2022</td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <span class="bg-purple-100 text-purple-800 text-xs font-medium px-2 py-1 rounded">HANDLING</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <button>--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216145/Button_c2kv6s.png" alt="">--%>
<%--                    </button>--%>
<%--                    <button class="open-modal text-red-500 hover:text-red-700">--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216158/_Button_base_z4xsuv.png" alt="Open Modal" />--%>
<%--                    </button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr class="border-b">--%>
<%--                <td class="py-3 px-4">6</td>--%>
<%--                <td class="py-3 px-4">Tech Lead Toyota</td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                        <span class="bg-orange-100 text-orange-700 px-2 py-1 rounded text-xs">Front End</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">10/10/2022</td>--%>
<%--                <td class="py-3 px-4">10/11/2022</td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <span class="bg-blue-100 text-blue-800 text-xs font-medium px-2 py-1 rounded">INTERVIEWING</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <button>--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216145/Button_c2kv6s.png" alt="">--%>
<%--                    </button>--%>
<%--                    <button class="open-modal text-red-500 hover:text-red-700">--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216158/_Button_base_z4xsuv.png" alt="Open Modal" />--%>
<%--                    </button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr class="border-b">--%>
<%--                <td class="py-3 px-4">7</td>--%>
<%--                <td class="py-3 px-4">Software Engineer Mobile</td>--%>
<%--                <td class="px-4 py-2 space-x-1">--%>
<%--                        <span class="bg-orange-100 text-orange-700 px-2 py-1 rounded text-xs">Front End</span>--%>
<%--                    <span class="bg-orange-100 text-yellow-800 text-xs font-medium px-2 py-1 rounded mt-1">Back End</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">10/10/2022</td>--%>
<%--                <td class="py-3 px-4">10/11/2022</td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <span class="bg-blue-100 text-blue-800 text-xs font-medium px-2 py-1 rounded">INTERVIEWING</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <button>--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216145/Button_c2kv6s.png" alt="">--%>
<%--                    </button>--%>
<%--                    <button class="open-modal text-red-500 hover:text-red-700">--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216158/_Button_base_z4xsuv.png" alt="Open Modal" />--%>
<%--                    </button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td class="py-3 px-4">8</td>--%>
<%--                <td class="py-3 px-4">BrSE Yamaha</td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                        <span class="bg-orange-100 text-orange-700 px-2 py-1 rounded text-xs">Front End</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">10/10/2022</td>--%>
<%--                <td class="py-3 px-4">10/11/2022</td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <span class="bg-green-100 text-green-800 text-xs font-medium px-2 py-1 rounded">DONE</span>--%>
<%--                </td>--%>
<%--                <td class="py-3 px-4">--%>
<%--                    <button>--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216145/Button_c2kv6s.png" alt="">--%>
<%--                    </button>--%>
<%--                    <button class="open-modal text-red-500 hover:text-red-700">--%>
<%--                        <img src="https://res.cloudinary.com/dmghszorv/image/upload/v1750216158/_Button_base_z4xsuv.png" alt="Open Modal" />--%>
<%--                    </button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--    </div>--%>

<%--    <!-- Pagination -->--%>
<%--    <div class="bg-white shadow-md p-4 flex justify-end items-center rounded-b-md">--%>
<%--        <div class="flex space-x-2">--%>
<%--            <button class="px-3 py-1 text-gray-500 hover:text-gray-700">Prev</button>--%>
<%--            <button class="px-3 py-1 bg-gray-200 text-gray-700">1</button>--%>
<%--            <button class="px-3 py-1 text-gray-500 hover:text-gray-700">2</button>--%>
<%--            <button class="px-3 py-1 text-gray-500 hover:text-gray-700">3</button>--%>
<%--            <button class="px-3 py-1 text-gray-500 hover:text-gray-700">4</button>--%>
<%--            <button class="px-3 py-1 text-gray-500 hover:text-gray-700">5</button>--%>
<%--            <button class="px-3 py-1 text-gray-500 hover:text-gray-700">6</button>--%>
<%--            <button class="px-3 py-1 text-gray-500 hover:text-gray-700">7</button>--%>
<%--            <button class="px-3 py-1 text-gray-500 hover:text-gray-700">Next</button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div><!-- Modal -->--%>
<%--<!-- Modal -->--%>
<%--<div id="approveModal" class="modal hidden fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center z-50">--%>
<%--    <div class="bg-white p-6 rounded shadow-lg w-full max-w-md relative">--%>
<%--        <button id="closeModal" class="absolute top-2 right-2 text-gray-400 hover:text-gray-600 text-2xl">&times;</button>--%>
<%--        <h2 class="text-lg font-semibold mb-2">Approve Interview</h2>--%>
<%--        <div class="space-y-2">--%>
<%--            <p><strong>Created At:</strong> <span id="createdAt">10/10/2022</span></p>--%>
<%--            <p><strong>Update At:</strong> <span id="updateAt">10/11/2022</span></p>--%>
<%--            <p><strong>Interview Time:</strong> <span id="interviewTime">20/10/2022 10:10 AM</span></p>--%>
<%--            <p><strong>Interview Link:</strong> <a href="#" id="interviewLink" class="text-blue-500 underline">Join Meeting</a></p>--%>
<%--        </div>--%>
<%--        <div class="flex justify-end mt-4 space-x-2">--%>
<%--            <button class="bg-gray-200 text-gray-700 px-4 py-2 rounded hover:bg-gray-300" id="cancelBtn">Cancel</button>--%>
<%--            <button class="bg-red-600 text-white px-4 py-2 rounded hover:bg-red-700" id="approveBtn">Approve</button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--&lt;%&ndash;<style>&ndash;%&gt;--%>
<%--&lt;%&ndash;    .modal {&ndash;%&gt;--%>
<%--&lt;%&ndash;        display: none;&ndash;%&gt;--%>
<%--&lt;%&ndash;        position: fixed;&ndash;%&gt;--%>
<%--&lt;%&ndash;        top: 0;&ndash;%&gt;--%>
<%--&lt;%&ndash;        left: 0;&ndash;%&gt;--%>
<%--&lt;%&ndash;        width: 100%;&ndash;%&gt;--%>
<%--&lt;%&ndash;        height: 100%;&ndash;%&gt;--%>
<%--&lt;%&ndash;        background-color: rgba(0, 0, 0, 0.5);&ndash;%&gt;--%>
<%--&lt;%&ndash;        justify-content: center;&ndash;%&gt;--%>
<%--&lt;%&ndash;        align-items: center;&ndash;%&gt;--%>
<%--&lt;%&ndash;    }&ndash;%&gt;--%>
<%--&lt;%&ndash;    .modal-content {&ndash;%&gt;--%>
<%--&lt;%&ndash;        background-color: white;&ndash;%&gt;--%>
<%--&lt;%&ndash;        padding: 20px;&ndash;%&gt;--%>
<%--&lt;%&ndash;        border-radius: 5px;&ndash;%&gt;--%>
<%--&lt;%&ndash;        width: 300px;&ndash;%&gt;--%>
<%--&lt;%&ndash;        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);&ndash;%&gt;--%>
<%--&lt;%&ndash;        text-align: left;&ndash;%&gt;--%>
<%--&lt;%&ndash;    }&ndash;%&gt;--%>
<%--&lt;%&ndash;    .close {&ndash;%&gt;--%>
<%--&lt;%&ndash;        float: right;&ndash;%&gt;--%>
<%--&lt;%&ndash;        font-size: 24px;&ndash;%&gt;--%>
<%--&lt;%&ndash;        cursor: pointer;&ndash;%&gt;--%>
<%--&lt;%&ndash;    }&ndash;%&gt;--%>
<%--&lt;%&ndash;</style>&ndash;%&gt;--%>
<%--<script>--%>
<%--    const modal = document.getElementById("approveModal");--%>
<%--    const openBtns = document.querySelectorAll(".open-modal");--%>
<%--    const closeModalBtn = document.getElementById("closeModal");--%>
<%--    const cancelBtn = document.getElementById("cancelBtn");--%>

<%--    openBtns.forEach(btn => {--%>
<%--        btn.addEventListener("click", () => {--%>
<%--            modal.classList.remove("hidden");--%>
<%--        });--%>
<%--    });--%>

<%--    closeModalBtn.addEventListener("click", () => {--%>
<%--        modal.classList.add("hidden");--%>
<%--    });--%>

<%--    cancelBtn.addEventListener("click", () => {--%>
<%--        modal.classList.add("hidden");--%>
<%--    });--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>


<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>JSP - Hello World</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>

<%--</body>--%>
<%--</html>--%>
