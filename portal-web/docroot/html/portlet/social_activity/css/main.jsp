<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/css_init.jsp" %>

.portlet-social-activity h4 {
	font-size: 1.2em;
	margin-bottom: 10px;
}

.social-activity-items {
	h4 {
		font-size: 1.1em;
		margin-bottom: 0px;
	}

	.aui-field-choice {
		display: inline-block;
	}

	.social-activity-item {
		cursor: pointer;
		padding: 6px 0px 6px 3px;
		position: relative;

		.social-activity-item-content {
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap;
		}

		a {
			color: #000;
			text-decoration:none;
		}
	}

	.social-activity-item:hover {
		background-color: #CDE5FD;
	}

	.social-activity-item.selected {
		background-color: #83BFFA;
	}

	.social-activity-item.selected:after {
		border: 14px solid #83BFFA;
		border-color: transparent transparent transparent #83BFFA;
		content: '';
		display: block;
		left: 100%;
		margin-top: -14px;
		position: absolute;
		top: 50%;
		z-index: 2;
	}
}

.social-activity-details {
	.aui-settings-display .aui-settings-display-content {
		background-color: #FFF;
		border: 1px solid #CCC;
		margin: 0px 15px 5px 0px;
		padding: 0px 15px;

		.aui-settings-field {
			font-weight: bold;
			list-style: none;

			.aui-settings-field-content {
				position: relative;

				select {
					margin: 0px 4px;
					padding: 3px;
				}
			}

			.field-text {
				font-weight: normal;
				margin-bottom: 3px;
			}

			.field-contribution-text {
				color: #333;
				display: block;
				font-size: 0.95em;
				margin-top: 3px;
			}

			.settings-controls {
				display: none;
			}
		}
		.container-drop-box {
			margin: 0;
			min-height: 130px;

			.content-field {
				border-bottom: 1px solid #ccc;
				padding: 8px 0 8px 10px;

				.settings-controls {
					display: block;
				}

				.settings-label {
					display: block;
					margin-bottom: 0.5em;
				}
			}
		}

		.aui-button-row {
			padding: 5px 0;
		}

		.settings-header {
			border-bottom: 1px solid #ccc;
			padding: 10px 0;

			.actions-conjunction {
				display: inline-block;
				font-weight: bold;
				list-style: none;
				padding: 10px 5px;
			}

			.settings-actions {
				display: inline-block;
				margin: 0px;
			}

			.settings-header-label {
				font-weight: bold;
				padding: 0 5px;
			}

			.action-field {
				background-image: url(<%= themeImagesPath %>/common/add.png);
				background-position: 5px 50%;
				background-repeat: no-repeat;
				padding-left: 25px;
			}
		}

		.settings-field-buttons {
			display: inline-block;
			position: absolute;
			right: 0;
			top: 0;

			.settings-button {
				float: left;
			}

			.settings-icon {
				background: none no-repeat 0 50%;
				display: block;
				height: 16px;
				padding: 0;
				right: 0;
				width: 16px;
			}

			.settings-icon-close {
				background-image: url(<%= themeImagesPath %>/portlet/close.png);
			}

			.settings-icon-toggle {
				background-image: url(<%= themeImagesPath %>/arrows/05_right.png);
				font-size: 0.9em;
				font-weight: normal;
				padding: 0 16px 0 12px;
				width: auto;
			}

			.settings-icon-expanded {
				background-image: url(<%= themeImagesPath %>/arrows/05_down.png);
			}
		}

		.settings-limit {
			margin-left: 12px;

			.settings-limit-row {
				margin: 5px 0;
			}
		}
	}
}