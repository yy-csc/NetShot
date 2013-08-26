<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="menuList" value='${sessionScope.menuInfo}' />
<c:set var="clickUrl" value='${sessionScope.clickSlidingUrl}' />

<div>
	<ul id="sliding-navigation">
		<c:forEach var="menu" items="${menuList}">
			<c:choose>
				<c:when test="${menu.menuLevel eq '1'}">
					<li class="sliding-element"><h3>${menu.menuName}</h3></li>
				</c:when>
				<c:when test="${menu.menuLevel eq '2'}">
					<c:if test="${clickUrl eq null}">
						<li class="sliding-element"><a
							href="${menu.url}?clickSlidingUrl=${menu.url}">${menu.menuName}</a>
						</li>
					</c:if>
					<c:if test="${clickUrl ne null}">
						<c:if test="${menu.url ne clickUrl}">
							<li class="sliding-element"><a
								href="${menu.url}?clickSlidingUrl=${menu.url}">${menu.menuName}</a>
							</li>
						</c:if>
						<c:if test="${menu.url eq clickUrl}">
							<li class="click-element"><a
								href="${menu.url}?clickSlidingUrl=${menu.url}">${menu.menuName}</a>
								<c:remove var="clickUrl" scope="session"/>
							</li>
						</c:if>
					</c:if>
				</c:when>
			</c:choose>
		</c:forEach>
	</ul>
</div>
