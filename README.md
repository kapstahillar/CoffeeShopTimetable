<div id="top"></div>



<!-- PROJECT SHIELDS -->
[![MIT License][license-shield]][license-url]

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

<p>
A simple time booking manager for a coffeeshop. <br/>
This is a test assignment assined to me.
</p>

<p align="right">(<a href="#top">back to top</a>)</p>


### Built With


* [Spring Boot](https://spring.io/projects/spring-boot)
* [Vaadin 14](https://vaadin.com/docs/v14/)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

1. Maven 3
2. Java 11


### Installation


1. Clone the repo
   ```sh
   git clone https://github.com/kapstahillar/CoffeeShopTimetable.git
    ```
2. Change directory to CoffeeShopTimetable
   ```sh
   cd ./CoffeeShopTimetable
   ```
3. Run maven command
   ```
   mvn clean install spring-boot:run -Pproduction
   ```
4. Open local Tomcat server in browser

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

<p>
On opening a new browser window in localhost creates you a new customer. <br/> Customer cannot be accessed anymore after refreshin browser window. <br/>
On clicking a timeslot system tries to book you a slot. Slot can be boooked <br/> when there are any empty slots.

### LEGEND
![screenshot1]

1. Bookable timeslot. Has 3 empty slots
2. Booked by current client. Has 2 empty slots
3. Booked by current client. Has 0 empty slots
3. Booked up timeslot. Has 0 empty slots. Cannot be booked anymore.


</p>

<!-- ISSUES -->
## Issues


<p align="right">(<a href="#top">back to top</a>)</p>

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Hillar Kapsta - kapstahillar@gmail.com<br/>
LinkedIn: https://www.linkedin.com/in/hillar-kapsta-908614a6/
<br/>
Project Link: [https://github.com/kapstahillar/CoffeeShopTimetable](https://github.com/kapstahillar/CoffeeShopTimetable)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[screenshot1]: https://imgur.com/a/MzxeJTI
